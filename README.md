Stock Ticker Repository
=======================
FinViz is a free stock screener with an export feature. This utility project downloads and parses data for ~6700 stocks and etfs for use in
other applications that need a starting index of stocks by ticker symbol. The project also provides an in memory repository implementation for
querying stocks by ticker symbol, sector, country, etc.

See also: http://finviz.com/screener.ashx

Resources
=========
* Uses Apache Maven for dependency management and builds: http://maven.apache.org/
* Uses opencsv parsing library: http://opencsv.sourceforge.net/

Installing and running
======================
$ mvn test
$ mvn jar:jar
$ mvn exec:java -Dexec.mainClass="net.degiere.ticker.Main"
