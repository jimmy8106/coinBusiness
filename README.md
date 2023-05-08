# coinBusiness
coinBusiness project

幣別與其對應中文名稱的資料表<br>
建立 SQL 語法<br>
請見schema.sql與data.sql<br>
h2 console<br>
http://localhost:6070/coindesk/h2-console/<br>
建立新增修查API<br>
http://localhost:6070/coindesk/coins/queryAll<br>
http://localhost:6070/coindesk/coins/insert<br>
http://localhost:6070/coindesk/coins/update<br>
http://localhost:6070/coindesk/coins/delete<br>

呼叫 coindesk 的 API。<br>
curl -X GET http://localhost:6070/coindesk/coins/callApi

呼叫 coindesk 的 API，並進行資料轉換，組成新 API。<br>
此新 API 提供：<br>
A. 更新時間（時間格式範例：1990/01/01 00:00:00）。<br>
B. 幣別相關資訊（幣別，幣別中文名稱，以及匯率）。<br>
curl -X GET http://localhost:6070/coindesk/coins/convertApi
