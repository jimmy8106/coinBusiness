# coinBusiness
coinBusiness project

幣別與其對應中文名稱的資料表
建立 SQL 語法
請見schema.sql與data.sql
h2 console
http://localhost:6070/coindesk/h2-console/
建立新增修查API
http://localhost:6070/coindesk/coins/queryAll
http://localhost:6070/coindesk/coins/insert
http://localhost:6070/coindesk/coins/update
http://localhost:6070/coindesk/coins/delete

呼叫 coindesk 的 API。
curl -X GET http://localhost:6070/coindesk/coins/callApi

呼叫 coindesk 的 API，並進行資料轉換，組成新 API。
此新 API 提供：
A. 更新時間（時間格式範例：1990/01/01 00:00:00）。
B. 幣別相關資訊（幣別，幣別中文名稱，以及匯率）。
curl -X GET http://localhost:6070/coindesk/coins/convertApi
