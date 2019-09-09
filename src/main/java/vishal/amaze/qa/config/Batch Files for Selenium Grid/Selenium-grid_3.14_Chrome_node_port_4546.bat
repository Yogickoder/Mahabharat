Echo off
Title ChromeDriver Node on 4546

Echo Setting Project Location for ChromeDriver Node
set projectLocation="C:\Selenium Grid
pushd %projectLocation%

Echo Setting Chromedriver path and creating node on 4546
java -Dwebdriver.chrome.driver="C:\Selenium Grid Drivers\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.11:4444/grid/register -port 4546
pause