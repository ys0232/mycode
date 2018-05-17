import pyecharts.constants as constants
# constants.CONFIGURATION['HOST'] = "https://cdn.kesci.com/nbextensions/echarts"
import warnings
from sklearn.metrics import log_loss

warnings.filterwarnings("ignore")
# matplotlib inline
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy import stats, integrate
import seaborn as sns
from pyecharts import Bar
from sklearn import preprocessing
from sklearn.preprocessing import scale
from collections import Counter
import time


def timestamp_datetime(value):
    format = '%Y-%m-%d %H:%M:%S'
    value = time.localtime(value)
    dt = time.strftime(format, value)
    return dt


def find_pre(n):
    pre_dic = {}
    res = []
    for i in n.values:
        if i in pre_dic:
            res.append(pre_dic[i])
            pre_dic[i] = pre_dic[i] + 1
        else:
            res.append(0)
            pre_dic[i] = 1
    return np.array(res)


def lowest(ss):
    reslen = len(ss.values)
    res = np.zeros(reslen)
    res[ss == ss.min()] = 1
    return res


def minmaxScale(df):
    min_data = df.min()
    max_data = df.max()
    dev_data = max_data - min_data
    return df.map(lambda x: (x - min_data) / dev_data)


def FFMFormatPandas(pd_data):
    col_list = pd_data.columns
    field_index = dict(zip(col_list, range(len(col_list))))
    base_index = 0
    for col in pd_data.columns:
        if pd_data[col].dtype == 'object':
            vals = pd_data[col].unique()
            index_dict = dict(zip(vals, range(len(vals))))
            pd_data[col] = pd_data[col].map(lambda x: (field_index[col], base_index + index_dict[x], 1))
            base_index += len(vals)
        else:
            pd_data[col] = np.round(minmaxScale(pd_data[col]), 6)
            vals = pd_data[col].unique()
            index_dict = dict(zip(vals, range(len(vals))))
            pd_data[col] = pd_data[col].map(lambda x: (field_index[col], base_index, x))
            base_index += 1

    return pd_data.values


def smooth(data, cols, alpha, beta):
    cols_all = list(set(data[cols].values))
    # bs=BayesianSmoothing(1,1)
    train = data[~data['is_trade'].isnull()]
    # print(type(train),train.info())
    # print(cols)
    traded = data[data['is_trade'] == 1]
    dic_i = dict(Counter(train[cols].values))
    dic_cov = dict(Counter(traded[cols].values))
    l = list(set(train[cols].values))
    I = []
    C = []
    for id in l:
        I.append(dic_i[id])
        if id not in dic_cov:
            C.append(0)
        else:
            C.append(dic_cov[id])
    # bs.update(I,C,100000,0.0001)
    # print(bs.alpha,bs.beta)
    # print(type(ph))
    dic_PH = {}
    for id in cols_all:
        if id not in dic_i:
            dic_PH[id] = (alpha) / (alpha + beta)
        elif id not in dic_cov:
            dic_PH[id] = (alpha) / (dic_i[id] + alpha + beta)
        else:
            dic_PH[id] = (dic_cov[id] + alpha) / (dic_i[id] + alpha + beta)
    values = cols + '_trade_pro'
    df_out = pd.DataFrame({cols: list(dic_PH.keys()),
                           values: list(dic_PH.keys())})
    data = pd.merge(data, df_out, on=[cols], how='left')
    return data


df_train = pd.read_csv('/home/yolin/tianchi/Advertising_transformation_prediction/round1_ijcai_18_train_20180301.txt',
                       sep="\s+")
# df_train = pd.read_csv('/home/yolin/tianchi/Advertising_transformation_prediction/round1_ijcai_18_train_20180301.txt',
# sep="\s+")
df_train = df_train.drop_duplicates(subset='instance_id')  # 把instance id去重
df_user = df_train
lbl = preprocessing.LabelEncoder()
# print(len(df_train['item_city_id'].unique()),len(df_train['item_brand_id'].unique()))
# df_train['len_item_category'] = df_train['item_category_list'].map(lambda x: len(str(x).split(';')))
# df_train['len_item_property'] = df_train['item_property_list'].map(lambda x: len(str(x).split(';')))
for i in range(1, 3):
    df_train['item_category_list' + str(i)] = lbl.fit_transform(df_train['item_category_list'].map(
        lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))  # item_category_list的第0列全部都一样
    # print(i,len(df_train['item_category_list' + str(i)].unique()))
# property_list = set()
for i in range(10):
    df_train['item_property_list' + str(i)] = lbl.fit_transform(
        df_train['item_property_list'].map(lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))
    # property_list = set(df_train['item_property_list' + str(i)].values) | property_list
    # print('property', i, len(property_list))
for col in ['context_page_id', 'user_occupation_id', 'user_gender_id', 'context_id', 'item_id', 'item_brand_id',
            'item_city_id', 'user_id', 'shop_id']:
    df_train[col] = lbl.fit_transform(df_train[col])
# df_train['len_predict_category_property'] = df_train['predict_category_property'].map(lambda x: len(str(x).split(';')))
predict_cp_list = set()
# print(df_train['predict_category_property'].map(lambda x: len(str(x).split(';'))).max())

for i in range(5):
    df_train['predict_category_property' + str(i)] = lbl.fit_transform(df_train['predict_category_property'].map(
        lambda x: str(str(x).split(';')[i]) if len(str(x).split(';')) > i else ''))
    # predict_cp_list |= set(df_train['predict_category_property' + str(i)].values)
    # print(df_train['predict_category_property' + str(i)])

df_train['realtime'] = df_train['context_timestamp'].apply(timestamp_datetime)
df_train['realtime'] = pd.to_datetime(df_train['realtime'])
df_train['day'] = df_train['realtime'].dt.day
df_train['hour'] = df_train['realtime'].dt.hour
feat = ['user_id', 'shop_id', 'item_id']
df_train = df_train.sort_values(by=['context_timestamp', 'instance_id'])
for id in feat:
    col = id + str('_times')
    id_cnt = df_train.groupby([id], as_index=False)['instance_id'].agg({col: 'count'})
    df_train = pd.merge(df_train, id_cnt, on=[id], how='left')

df_train['is_new'] = df_train['user_id_times'].apply(lambda x: x if x < 2 else 0)
# print(df_train.head())
# print(df_train['is_trade'].sum() / df_train.shape[0])
max_item_num = np.max(df_train['item_id_times'].max())
# print(max_item_num)
max_shop_num = np.max(df_train['shop_id_times'].max())
# print(max_shop_num)

fw = open("/home/yolin/tianchi/Advertising_transformation_prediction/src/smooth_simple.txt", 'r')
cols_smooth = fw.readline().strip().split(',')
value = [inst.strip().split(',') for inst in fw.readlines()]
ph = pd.DataFrame(value, columns=cols_smooth)
for col in ['shop_id', 'item_id', 'user_id']:
    alpha = float(ph[col].values[0])
    beta = float(ph[col].values[1])
    print(alpha, beta)
    df_train = smooth(df_train, col, alpha, beta)

df_train['max_same_item'] = df_train['item_id_times'].map(lambda x: x == max_item_num and 1 or 0)
df_train['max_same_shop'] = df_train['shop_id_times'].map(lambda x: x == max_shop_num and 1 or 0)

df_train['pre_item'] = df_train.groupby('user_id')['item_id'].transform(find_pre)
df_train['pre_shop'] = df_train.groupby('user_id')['shop_id'].transform(find_pre)
df_train['pre_context'] = df_train.groupby('user_id')['context_id'].transform(find_pre)

import lightgbm as lgb
from sklearn.model_selection import train_test_split

category_features = ['context_page_id', 'user_occupation_id', 'user_gender_id', 'context_id', 'item_id',
                     'user_id', 'shop_id', 'is_new', 'max_same_item', 'max_same_shop']

train = df_train[(df_train['day'] >= 18) & (df_train['day'] <= 23)]
test = df_train[(df_train['day'] == 24)]
col = [c for c in train if
       c not in ['is_trade', 'item_category_list', 'item_property_list', 'predict_category_property', 'instance_id',
                 'realtime', 'context_timestamp']]

X = train[col]
print(X.shape[0])
y = train['is_trade'].values
x_test = test[col]
y_test = test['is_trade'].values
train_data = lgb.Dataset(X, label=y)
test_data = lgb.Dataset(x_test, label=y_test, reference=train_data)

y_pred = np.zeros(len(y))
baseline = log_loss(y, y_pred)
print(baseline)
param = {
    "objective": "binary",
    "learning_rate": 0.06,
    "max_depth": 8,
    "num_leaves": 32,
    "num_threads": 8,
}
num_round =800
bst = lgb.train(param, train_data, num_round, valid_sets=[train_data, test_data], early_stopping_rounds=100,
                verbose_eval=50,
                categorical_feature=category_features)

raw_ffm_data = df_train
for cols in category_features:
    raw_ffm_data[cols] = raw_ffm_data[cols].astype(str)
data_ffm = FFMFormatPandas(raw_ffm_data[col])
data_ffm_y = raw_ffm_data['is_trade'].tolist()
train_num=X.shape[0]
X_train_ffm = data_ffm[:train_num]
X_test_ffm = data_ffm[train_num:]
y_train_ffm = data_ffm_y[:train_num]
y_test_ffm = data_ffm_y[train_num:]
import ffm
ffm_train = ffm.FFMData(X_train_ffm,y_train_ffm)
ffm_test = ffm.FFMData(X_test_ffm,y_test_ffm)

n_iter = 5

ffmmodel = ffm.FFM(eta=0.02, lam=0.0001, k=6)
ffmmodel.init_model(ffm_train)

for i in range(n_iter):
    print('iteration %d : ' % i)
    ffmmodel.iteration(ffm_train)

    y_pred = ffmmodel.predict(ffm_test)
    t_pred = ffmmodel.predict(ffm_train)
    #auc = roc_auc_score(y_test_ffm, y_pred)
    logloss = log_loss(y_test_ffm, y_pred)
    #t_auc = roc_auc_score(y_train_ffm, t_pred)
    t_logloss = log_loss(y_train_ffm, t_pred)
    print('train log_loss %.4f' % (t_logloss), end='\t')
    print('test log_loss %.4f' % (logloss))
