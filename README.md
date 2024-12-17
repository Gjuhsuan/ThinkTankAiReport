# ThinkTankAiReport
24秋java

作业描述：论文/智库报告与大模型
（1）下载一批出口管制主题相关的研究论文和智库报告，将其存入MySQL数据库。调研将论文/智库报告PDF文件向量化的技术路线。
（2）基于前述技术路线，构建B/S模式信息系统，实现对论文、报告的增删改查的基础功能。用户给定主题后，系统基于大模型撰写一份给定主题（收集的论文/报告的子主题，例如“芯片出口管制”等）的报告，要求用户可以自由选择是否连接互联网，如果连接联网，则模型会参考互联网资料以及论文/智库报告，否则只参考论文/智库报告数据。
针对撰写的报告，如果参考了数据库的报告，则需要列出来参考了哪一篇。
（3）如果有合适的回答结果，允许用户将回答结果一键存为word文件导出。

数据源：【http://www.cggthinktank.com/】中国智库
【https://cset.georgetown.edu/】【https://crsreports.congress.gov/】国外智库
【https://www.cnki.net/】【https://www.webofscience.com/wos/】论文库等。