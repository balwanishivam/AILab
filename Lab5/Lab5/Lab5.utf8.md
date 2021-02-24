
<!-- rnb-text-begin -->

---
title: "Week-5"
author: "QuickFixDemos"
output:
  html_document:
    df_print: paged
  html_notebook: default
  pdf_document: default
---
Packages Used Installation

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuIyBpbnN0YWxsLnBhY2thZ2VzKFwiZTEwNzFcIikgXG4jIGluc3RhbGwucGFja2FnZXMoXCJjYVRvb2xzXCIpIFxuIyBpbnN0YWxsLnBhY2thZ2VzKFwiY2FyZXRcIikgXG4jIGluc3RhbGwucGFja2FnZXMoXCJibmxlYXJuXCIpXG5gYGAifQ== -->

```r
# install.packages("e1071") 
# install.packages("caTools") 
# install.packages("caret") 
# install.packages("bnlearn")
```

<!-- rnb-source-end -->

<!-- rnb-chunk-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxubGlicmFyeShibmxlYXJuKVxubGlicmFyeShlMTA3MSkgXG5gYGAifQ== -->

```r
library(bnlearn)
library(e1071) 
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiXG5BdHRhY2hpbmcgcGFja2FnZTog46S847ixZTEwNzHjpLzjuLJcblxuVGhlIGZvbGxvd2luZyBvYmplY3QgaXMgbWFza2VkIGZyb20g46S847ixcGFja2FnZTpibmxlYXJu46S847iyOlxuXG4gICAgaW1wdXRlXG4ifQ== -->

```

Attaching package: 㤼㸱e1071㤼㸲

The following object is masked from 㤼㸱package:bnlearn㤼㸲:

    impute
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxubGlicmFyeShjYVRvb2xzKSBcbmxpYnJhcnkoY2FyZXQpIFxuYGBgIn0= -->

```r
library(caTools) 
library(caret) 
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiTG9hZGluZyByZXF1aXJlZCBwYWNrYWdlOiBsYXR0aWNlXG5Mb2FkaW5nIHJlcXVpcmVkIHBhY2thZ2U6IGdncGxvdDJcblJlZ2lzdGVyZWQgUzMgbWV0aG9kIG92ZXJ3cml0dGVuIGJ5ICdkYXRhLnRhYmxlJzpcbiAgbWV0aG9kICAgICAgICAgICBmcm9tXG4gIHByaW50LmRhdGEudGFibGUgICAgIFxuIn0= -->

```
Loading required package: lattice
Loading required package: ggplot2
Registered S3 method overwritten by 'data.table':
  method           from
  print.data.table     
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->

Lab Assignment 5

Learning Objective:
Understand the graphical models for inference under uncertainty, build Bayesian Network in R, Learn the structure and CPTs from Data, naive Bayes classification with dependency between features. 
Problem Statement:
A table containing grades earned by students in respective courses is made available to you in (codes folder) 2020_bn_nb_data.txt. 
Q1: Consider grades earned in each of the courses as random variables and learn the dependencies between courses. 
##Solution

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldDwtcmVhZC50YWJsZShcIkM6L1VzZXJzL3NoaXZhL09uZURyaXZlL0Rlc2t0b3AvU2VtZXN0ZXItNi9BSUxhYi9MYWI1LzIwMjBfYm5fbmJfZGF0YS50eHRcIixoZWFkPVRSVUUsc3RyaW5nc0FzRmFjdG9ycz1UUlVFKVxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldFxuZGF0YXNldF9uZXQ8LWhjKGRhdGFzZXRfZ3JhZGVzLHNjb3JlPVwiazJcIilcbmRhdGFzZXRfbmV0XG5gYGAifQ== -->

```r
dataset<-read.table("C:/Users/shiva/OneDrive/Desktop/Semester-6/AILab/Lab5/2020_bn_nb_data.txt",head=TRUE,stringsAsFactors=TRUE)
dataset_grades=dataset
dataset_net<-hc(dataset_grades,score="k2")
dataset_net
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiXG4gIEJheWVzaWFuIG5ldHdvcmsgbGVhcm5lZCB2aWEgU2NvcmUtYmFzZWQgbWV0aG9kc1xuXG4gIG1vZGVsOlxuICAgW01BMTAxXVtFQzEwMHxNQTEwMV1bUEgxMDB8RUMxMDBdW1FQfEVDMTAwXVtFQzE2MHxRUF1bSVQxMDF8UVBdW1BIMTYwfFFQXVtIUzEwMXxRUF1bSVQxNjF8SVQxMDFdIFxuICBub2RlczogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA5IFxuICBhcmNzOiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA4IFxuICAgIHVuZGlyZWN0ZWQgYXJjczogICAgICAgICAgICAgICAgICAgICAwIFxuICAgIGRpcmVjdGVkIGFyY3M6ICAgICAgICAgICAgICAgICAgICAgICA4IFxuICBhdmVyYWdlIG1hcmtvdiBibGFua2V0IHNpemU6ICAgICAgICAgICAxLjc4IFxuICBhdmVyYWdlIG5laWdoYm91cmhvb2Qgc2l6ZTogICAgICAgICAgICAxLjc4IFxuICBhdmVyYWdlIGJyYW5jaGluZyBmYWN0b3I6ICAgICAgICAgICAgICAwLjg5IFxuXG4gIGxlYXJuaW5nIGFsZ29yaXRobTogICAgICAgICAgICAgICAgICAgIEhpbGwtQ2xpbWJpbmcgXG4gIHNjb3JlOiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIENvb3BlciAmIEhlcnNrb3ZpdHMnIEsyIFxuICB0ZXN0cyB1c2VkIGluIHRoZSBsZWFybmluZyBwcm9jZWR1cmU6ICAxNjggXG4gIG9wdGltaXplZDogICAgICAgICAgICAgICAgICAgICAgICAgICAgIFRSVUUgXG4ifQ== -->

```

  Bayesian network learned via Score-based methods

  model:
   [MA101][EC100|MA101][PH100|EC100][QP|EC100][EC160|QP][IT101|QP][PH160|QP][HS101|QP][IT161|IT101] 
  nodes:                                 9 
  arcs:                                  8 
    undirected arcs:                     0 
    directed arcs:                       8 
  average markov blanket size:           1.78 
  average neighbourhood size:            1.78 
  average branching factor:              0.89 

  learning algorithm:                    Hill-Climbing 
  score:                                 Cooper & Herskovits' K2 
  tests used in the learning procedure:  168 
  optimized:                             TRUE 
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxucGxvdChkYXRhc2V0X25ldClcbmBgYCJ9 -->

```r
plot(dataset_net)
```

<!-- rnb-source-end -->

<!-- rnb-plot-begin eyJoZWlnaHQiOjQzMi42MzI5LCJ3aWR0aCI6NzAwLCJzaXplX2JlaGF2aW9yIjowLCJjb25kaXRpb25zIjpbXX0= -->

<img src="data:image/png;base64,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" />

<!-- rnb-plot-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->


Q2: Using the data, learn the CPTs for each course node.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldF9uZXRfYm5fZml0IDwtIGJuLmZpdChkYXRhc2V0X25ldCwgZGF0YXNldF9ncmFkZXMgKVxucHJpbnQoZGF0YXNldF9uZXRfYm5fZml0KVxuYGBgIn0= -->

```r
dataset_net_bn_fit <- bn.fit(dataset_net, dataset_grades )
print(dataset_net_bn_fit)
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiXG4gIEJheWVzaWFuIG5ldHdvcmsgcGFyYW1ldGVyc1xuXG4gIFBhcmFtZXRlcnMgb2Ygbm9kZSBFQzEwMCAobXVsdGlub21pYWwgZGlzdHJpYnV0aW9uKVxuXG5Db25kaXRpb25hbCBwcm9iYWJpbGl0eSB0YWJsZTpcbiBcbiAgICAgTUExMDFcbkVDMTAwICAgICAgICAgQUEgICAgICAgICBBQiAgICAgICAgIEJCICAgICAgICAgQkMgICAgICAgICBDQyAgICAgICAgIENEICAgICAgICAgREQgICAgICAgICAgRlxuICAgQUEgMC43NTAwMDAwMCAwLjA3NjkyMzA4IDAuMDM4NDYxNTQgMC4wMTg1MTg1MiAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBBQiAwLjAwMDAwMDAwIDAuNDYxNTM4NDYgMC4yNTAwMDAwMCAwLjA1NTU1NTU2IDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDBcbiAgIEJCIDAuMjUwMDAwMDAgMC4yMzA3NjkyMyAwLjMyNjkyMzA4IDAuMjIyMjIyMjIgMC4wNDA4MTYzMyAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMFxuICAgQkMgMC4wMDAwMDAwMCAwLjE1Mzg0NjE1IDAuMjg4NDYxNTQgMC4yNzc3Nzc3OCAwLjMyNjUzMDYxIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBDQyAwLjAwMDAwMDAwIDAuMDc2OTIzMDggMC4wOTYxNTM4NSAwLjI0MDc0MDc0IDAuMzI2NTMwNjEgMC4wNDE2NjY2NyAwLjAwMDAwMDAwIDAuMDAwMDAwMDBcbiAgIENEIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMTI5NjI5NjMgMC4yNjUzMDYxMiAwLjMzMzMzMzMzIDAuMDQ3NjE5MDUgMC4wMDAwMDAwMFxuICAgREQgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMzcwMzcwNCAwLjA0MDgxNjMzIDAuNTAwMDAwMDAgMC4xOTA0NzYxOSAwLjAwMDAwMDAwXG4gICBGICAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAxODUxODUyIDAuMDAwMDAwMDAgMC4xMjUwMDAwMCAwLjc2MTkwNDc2IDEuMDAwMDAwMDBcblxuICBQYXJhbWV0ZXJzIG9mIG5vZGUgRUMxNjAgKG11bHRpbm9taWFsIGRpc3RyaWJ1dGlvbilcblxuQ29uZGl0aW9uYWwgcHJvYmFiaWxpdHkgdGFibGU6XG4gXG4gICAgIFFQXG5FQzE2MCAgICAgICAgICBuICAgICAgICAgIHlcbiAgIEFBIDAuMDAwMDAwMDAgMC4wNzUwMDAwMFxuICAgQUIgMC4wMDAwMDAwMCAwLjEwMDAwMDAwXG4gICBCQiAwLjAxMzg4ODg5IDAuMTg3NTAwMDBcbiAgIEJDIDAuMDEzODg4ODkgMC4zNjI1MDAwMFxuICAgQ0MgMC4xNTI3Nzc3OCAwLjIyNTAwMDAwXG4gICBDRCAwLjQ0NDQ0NDQ0IDAuMDMxMjUwMDBcbiAgIEREIDAuMjYzODg4ODkgMC4wMTg3NTAwMFxuICAgRiAgMC4xMTExMTExMSAwLjAwMDAwMDAwXG5cbiAgUGFyYW1ldGVycyBvZiBub2RlIElUMTAxIChtdWx0aW5vbWlhbCBkaXN0cmlidXRpb24pXG5cbkNvbmRpdGlvbmFsIHByb2JhYmlsaXR5IHRhYmxlOlxuIFxuICAgICBRUFxuSVQxMDEgICAgICAgICAgbiAgICAgICAgICB5XG4gICBBQSAwLjAwMDAwMDAwIDAuMDc1MDAwMDBcbiAgIEFCIDAuMDAwMDAwMDAgMC4xNTYyNTAwMFxuICAgQkIgMC4wNDE2NjY2NyAwLjE5Mzc1MDAwXG4gICBCQyAwLjAyNzc3Nzc4IDAuMjkzNzUwMDBcbiAgIENDIDAuMTM4ODg4ODkgMC4yMDAwMDAwMFxuICAgQ0QgMC4zMDU1NTU1NiAwLjA4MTI1MDAwXG4gICBERCAwLjMxOTQ0NDQ0IDAuMDAwMDAwMDBcbiAgIEYgIDAuMTY2NjY2NjcgMC4wMDAwMDAwMFxuXG4gIFBhcmFtZXRlcnMgb2Ygbm9kZSBJVDE2MSAobXVsdGlub21pYWwgZGlzdHJpYnV0aW9uKVxuXG5Db25kaXRpb25hbCBwcm9iYWJpbGl0eSB0YWJsZTpcbiBcbiAgICAgSVQxMDFcbklUMTYxICAgICAgICAgQUEgICAgICAgICBBQiAgICAgICAgIEJCICAgICAgICAgQkMgICAgICAgICBDQyAgICAgICAgIENEICAgICAgICAgREQgICAgICAgICAgRlxuICAgQUEgMC41ODMzMzMzMyAwLjI0MDAwMDAwIDAuMTQ3MDU4ODIgMC4wNDA4MTYzMyAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBBQiAwLjE2NjY2NjY3IDAuNDAwMDAwMDAgMC4yOTQxMTc2NSAwLjAyMDQwODE2IDAuMDQ3NjE5MDUgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDBcbiAgIEJCIDAuMTY2NjY2NjcgMC4yNDAwMDAwMCAwLjMyMzUyOTQxIDAuMjA0MDgxNjMgMC4xMTkwNDc2MiAwLjAyODU3MTQzIDAuMDAwMDAwMDAgMC4wMDAwMDAwMFxuICAgQkMgMC4wODMzMzMzMyAwLjA0MDAwMDAwIDAuMjA1ODgyMzUgMC4zNjczNDY5NCAwLjM4MDk1MjM4IDAuMTcxNDI4NTcgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBDQyAwLjAwMDAwMDAwIDAuMDQwMDAwMDAgMC4wMDAwMDAwMCAwLjI0NDg5Nzk2IDAuMzMzMzMzMzMgMC4zMTQyODU3MSAwLjA4Njk1NjUyIDAuMTY2NjY2NjdcbiAgIENEIDAuMDAwMDAwMDAgMC4wNDAwMDAwMCAwLjAyOTQxMTc2IDAuMTAyMDQwODIgMC4wOTUyMzgxMCAwLjMxNDI4NTcxIDAuNTIxNzM5MTMgMC4wODMzMzMzM1xuICAgREQgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMjA0MDgxNiAwLjAyMzgwOTUyIDAuMTQyODU3MTQgMC4zOTEzMDQzNSAwLjU4MzMzMzMzXG4gICBGICAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMjg1NzE0MyAwLjAwMDAwMDAwIDAuMTY2NjY2NjdcblxuICBQYXJhbWV0ZXJzIG9mIG5vZGUgTUExMDEgKG11bHRpbm9taWFsIGRpc3RyaWJ1dGlvbilcblxuQ29uZGl0aW9uYWwgcHJvYmFiaWxpdHkgdGFibGU6XG4gICAgICAgICBBQSAgICAgICAgIEFCICAgICAgICAgQkIgICAgICAgICBCQyAgICAgICAgIENDICAgICAgICAgQ0QgICAgICAgICBERCAgICAgICAgICBGIFxuMC4wMTcyNDEzOCAwLjA1NjAzNDQ4IDAuMjI0MTM3OTMgMC4yMzI3NTg2MiAwLjIxMTIwNjkwIDAuMTAzNDQ4MjggMC4wOTA1MTcyNCAwLjA2NDY1NTE3IFxuXG4gIFBhcmFtZXRlcnMgb2Ygbm9kZSBQSDEwMCAobXVsdGlub21pYWwgZGlzdHJpYnV0aW9uKVxuXG5Db25kaXRpb25hbCBwcm9iYWJpbGl0eSB0YWJsZTpcbiBcbiAgICAgRUMxMDBcblBIMTAwICAgICAgICAgQUEgICAgICAgICBBQiAgICAgICAgIEJCICAgICAgICAgQkMgICAgICAgICBDQyAgICAgICAgIENEICAgICAgICAgREQgICAgICAgICAgRlxuICAgQUEgMC43MTQyODU3MSAwLjQwOTA5MDkxIDAuMjI4NTcxNDMgMC4wODMzMzMzMyAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBBQiAwLjE0Mjg1NzE0IDAuMzE4MTgxODIgMC4yMDAwMDAwMCAwLjE4NzUwMDAwIDAuMDU1NTU1NTYgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDBcbiAgIEJCIDAuMDAwMDAwMDAgMC4xODE4MTgxOCAwLjMxNDI4NTcxIDAuMjkxNjY2NjcgMC4xMzg4ODg4OSAwLjAzNDQ4Mjc2IDAuMDUwMDAwMDAgMC4wMDAwMDAwMFxuICAgQkMgMC4xNDI4NTcxNCAwLjA0NTQ1NDU1IDAuMTQyODU3MTQgMC4yMjkxNjY2NyAwLjMzMzMzMzMzIDAuMTM3OTMxMDMgMC4wMDAwMDAwMCAwLjAwMDAwMDAwXG4gICBDQyAwLjAwMDAwMDAwIDAuMDQ1NDU0NTUgMC4xMTQyODU3MSAwLjE4NzUwMDAwIDAuMjUwMDAwMDAgMC40MTM3OTMxMCAwLjIwMDAwMDAwIDAuMDI4NTcxNDNcbiAgIENEIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDIwODMzMzMgMC4xOTQ0NDQ0NCAwLjMxMDM0NDgzIDAuNDUwMDAwMDAgMC4xMTQyODU3MVxuICAgREQgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAyNzc3Nzc4IDAuMTAzNDQ4MjggMC4yMDAwMDAwMCAwLjQ1NzE0Mjg2XG4gICBGICAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjAwMDAwMDAwIDAuMDAwMDAwMDAgMC4wMDAwMDAwMCAwLjEwMDAwMDAwIDAuNDAwMDAwMDBcblxuICBQYXJhbWV0ZXJzIG9mIG5vZGUgUEgxNjAgKG11bHRpbm9taWFsIGRpc3RyaWJ1dGlvbilcblxuQ29uZGl0aW9uYWwgcHJvYmFiaWxpdHkgdGFibGU6XG4gXG4gICAgIFFQXG5QSDE2MCAgICAgICAgICBuICAgICAgICAgIHlcbiAgIEFBIDAuMDU1NTU1NTYgMC4xNDM3NTAwMFxuICAgQUIgMC4wOTcyMjIyMiAwLjE1NjI1MDAwXG4gICBCQiAwLjAyNzc3Nzc4IDAuMTc1MDAwMDBcbiAgIEJDIDAuMTgwNTU1NTYgMC4zNDM3NTAwMFxuICAgQ0MgMC4yOTE2NjY2NyAwLjEzNzUwMDAwXG4gICBDRCAwLjE5NDQ0NDQ0IDAuMDQzNzUwMDBcbiAgIEREIDAuMTI1MDAwMDAgMC4wMDAwMDAwMFxuICAgRiAgMC4wMjc3Nzc3OCAwLjAwMDAwMDAwXG5cbiAgUGFyYW1ldGVycyBvZiBub2RlIEhTMTAxIChtdWx0aW5vbWlhbCBkaXN0cmlidXRpb24pXG5cbkNvbmRpdGlvbmFsIHByb2JhYmlsaXR5IHRhYmxlOlxuIFxuICAgICBRUFxuSFMxMDEgICAgICAgICAgbiAgICAgICAgICB5XG4gICBBQSAwLjAwMDAwMDAwIDAuMjYyNTAwMDBcbiAgIEFCIDAuMDAwMDAwMDAgMC4yMTI1MDAwMFxuICAgQkIgMC4wNTU1NTU1NiAwLjIyNTAwMDAwXG4gICBCQyAwLjEyNTAwMDAwIDAuMTY4NzUwMDBcbiAgIENDIDAuMTgwNTU1NTYgMC4wODEyNTAwMFxuICAgQ0QgMC4xOTQ0NDQ0NCAwLjAzNzUwMDAwXG4gICBERCAwLjM3NTAwMDAwIDAuMDEyNTAwMDBcbiAgIEYgIDAuMDY5NDQ0NDQgMC4wMDAwMDAwMFxuXG4gIFBhcmFtZXRlcnMgb2Ygbm9kZSBRUCAobXVsdGlub21pYWwgZGlzdHJpYnV0aW9uKVxuXG5Db25kaXRpb25hbCBwcm9iYWJpbGl0eSB0YWJsZTpcbiBcbiAgIEVDMTAwXG5RUCAgICAgICAgIEFBICAgICAgICBBQiAgICAgICAgQkIgICAgICAgIEJDICAgICAgICBDQyAgICAgICAgQ0QgICAgICAgIEREICAgICAgICAgRlxuICBuIDAuMDAwMDAwMCAwLjAwMDAwMDAgMC4wMDAwMDAwIDAuMDAwMDAwMCAwLjEzODg4ODkgMC40NDgyNzU5IDAuOTUwMDAwMCAxLjAwMDAwMDBcbiAgeSAxLjAwMDAwMDAgMS4wMDAwMDAwIDEuMDAwMDAwMCAxLjAwMDAwMDAgMC44NjExMTExIDAuNTUxNzI0MSAwLjA1MDAwMDAgMC4wMDAwMDAwXG4ifQ== -->

```

  Bayesian network parameters

  Parameters of node EC100 (multinomial distribution)

Conditional probability table:
 
     MA101
EC100         AA         AB         BB         BC         CC         CD         DD          F
   AA 0.75000000 0.07692308 0.03846154 0.01851852 0.00000000 0.00000000 0.00000000 0.00000000
   AB 0.00000000 0.46153846 0.25000000 0.05555556 0.00000000 0.00000000 0.00000000 0.00000000
   BB 0.25000000 0.23076923 0.32692308 0.22222222 0.04081633 0.00000000 0.00000000 0.00000000
   BC 0.00000000 0.15384615 0.28846154 0.27777778 0.32653061 0.00000000 0.00000000 0.00000000
   CC 0.00000000 0.07692308 0.09615385 0.24074074 0.32653061 0.04166667 0.00000000 0.00000000
   CD 0.00000000 0.00000000 0.00000000 0.12962963 0.26530612 0.33333333 0.04761905 0.00000000
   DD 0.00000000 0.00000000 0.00000000 0.03703704 0.04081633 0.50000000 0.19047619 0.00000000
   F  0.00000000 0.00000000 0.00000000 0.01851852 0.00000000 0.12500000 0.76190476 1.00000000

  Parameters of node EC160 (multinomial distribution)

Conditional probability table:
 
     QP
EC160          n          y
   AA 0.00000000 0.07500000
   AB 0.00000000 0.10000000
   BB 0.01388889 0.18750000
   BC 0.01388889 0.36250000
   CC 0.15277778 0.22500000
   CD 0.44444444 0.03125000
   DD 0.26388889 0.01875000
   F  0.11111111 0.00000000

  Parameters of node IT101 (multinomial distribution)

Conditional probability table:
 
     QP
IT101          n          y
   AA 0.00000000 0.07500000
   AB 0.00000000 0.15625000
   BB 0.04166667 0.19375000
   BC 0.02777778 0.29375000
   CC 0.13888889 0.20000000
   CD 0.30555556 0.08125000
   DD 0.31944444 0.00000000
   F  0.16666667 0.00000000

  Parameters of node IT161 (multinomial distribution)

Conditional probability table:
 
     IT101
IT161         AA         AB         BB         BC         CC         CD         DD          F
   AA 0.58333333 0.24000000 0.14705882 0.04081633 0.00000000 0.00000000 0.00000000 0.00000000
   AB 0.16666667 0.40000000 0.29411765 0.02040816 0.04761905 0.00000000 0.00000000 0.00000000
   BB 0.16666667 0.24000000 0.32352941 0.20408163 0.11904762 0.02857143 0.00000000 0.00000000
   BC 0.08333333 0.04000000 0.20588235 0.36734694 0.38095238 0.17142857 0.00000000 0.00000000
   CC 0.00000000 0.04000000 0.00000000 0.24489796 0.33333333 0.31428571 0.08695652 0.16666667
   CD 0.00000000 0.04000000 0.02941176 0.10204082 0.09523810 0.31428571 0.52173913 0.08333333
   DD 0.00000000 0.00000000 0.00000000 0.02040816 0.02380952 0.14285714 0.39130435 0.58333333
   F  0.00000000 0.00000000 0.00000000 0.00000000 0.00000000 0.02857143 0.00000000 0.16666667

  Parameters of node MA101 (multinomial distribution)

Conditional probability table:
         AA         AB         BB         BC         CC         CD         DD          F 
0.01724138 0.05603448 0.22413793 0.23275862 0.21120690 0.10344828 0.09051724 0.06465517 

  Parameters of node PH100 (multinomial distribution)

Conditional probability table:
 
     EC100
PH100         AA         AB         BB         BC         CC         CD         DD          F
   AA 0.71428571 0.40909091 0.22857143 0.08333333 0.00000000 0.00000000 0.00000000 0.00000000
   AB 0.14285714 0.31818182 0.20000000 0.18750000 0.05555556 0.00000000 0.00000000 0.00000000
   BB 0.00000000 0.18181818 0.31428571 0.29166667 0.13888889 0.03448276 0.05000000 0.00000000
   BC 0.14285714 0.04545455 0.14285714 0.22916667 0.33333333 0.13793103 0.00000000 0.00000000
   CC 0.00000000 0.04545455 0.11428571 0.18750000 0.25000000 0.41379310 0.20000000 0.02857143
   CD 0.00000000 0.00000000 0.00000000 0.02083333 0.19444444 0.31034483 0.45000000 0.11428571
   DD 0.00000000 0.00000000 0.00000000 0.00000000 0.02777778 0.10344828 0.20000000 0.45714286
   F  0.00000000 0.00000000 0.00000000 0.00000000 0.00000000 0.00000000 0.10000000 0.40000000

  Parameters of node PH160 (multinomial distribution)

Conditional probability table:
 
     QP
PH160          n          y
   AA 0.05555556 0.14375000
   AB 0.09722222 0.15625000
   BB 0.02777778 0.17500000
   BC 0.18055556 0.34375000
   CC 0.29166667 0.13750000
   CD 0.19444444 0.04375000
   DD 0.12500000 0.00000000
   F  0.02777778 0.00000000

  Parameters of node HS101 (multinomial distribution)

Conditional probability table:
 
     QP
HS101          n          y
   AA 0.00000000 0.26250000
   AB 0.00000000 0.21250000
   BB 0.05555556 0.22500000
   BC 0.12500000 0.16875000
   CC 0.18055556 0.08125000
   CD 0.19444444 0.03750000
   DD 0.37500000 0.01250000
   F  0.06944444 0.00000000

  Parameters of node QP (multinomial distribution)

Conditional probability table:
 
   EC100
QP         AA        AB        BB        BC        CC        CD        DD         F
  n 0.0000000 0.0000000 0.0000000 0.0000000 0.1388889 0.4482759 0.9500000 1.0000000
  y 1.0000000 1.0000000 1.0000000 1.0000000 0.8611111 0.5517241 0.0500000 0.0000000
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->

Q3: What grade will a student get in PH100 if he earns DD in EC100, CC in IT101 and CD in MA101.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZ3JhZGVfbGlzdCA8LSBsaXN0KFwiQUFcIixcIkFCXCIsXCJCQlwiLFwiQkNcIixcIkNDXCIsXCJDRFwiLFwiRERcIixcIkZcIilcbnByb2JhYmlsaXR5IDwtIDAuMFxucmVzdWx0PVwiXCJcbmZvcihncmFkZSBpbiBncmFkZV9saXN0KSB7XG4gIHByb2IgPC0gY3BxdWVyeShkYXRhc2V0X25ldF9ibl9maXQsIGV2ZW50ID0gKFBIMTAwPT0gZ3JhZGUpLCBldmlkZW5jZSA9IChFQzEwMD09XCJERFwiICYgSVQxMDE9PVwiQ0NcIiAmIE1BMTAxPT1cIkNEXCIpKVxuICBpZihwcm9iYWJpbGl0eTxwcm9iKXtcbiAgICBwcm9iYWJpbGl0eT1wcm9iO1xuICAgIHJlc3VsdD1ncmFkZVxuICB9XG59XG5zcHJpbnRmKFwiVGhlIG1heCBwcm9iYWJpbGl0eSBvZiByZXN1bHRhbnQgZ3JhZGUgaXMgJWZcIixwcm9iYWJpbGl0eSlcbmBgYCJ9 -->

```r
grade_list <- list("AA","AB","BB","BC","CC","CD","DD","F")
probability <- 0.0
result=""
for(grade in grade_list) {
  prob <- cpquery(dataset_net_bn_fit, event = (PH100== grade), evidence = (EC100=="DD" & IT101=="CC" & MA101=="CD"))
  if(probability<prob){
    probability=prob;
    result=grade
  }
}
sprintf("The max probability of resultant grade is %f",probability)
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiWzFdIFwiVGhlIG1heCBwcm9iYWJpbGl0eSBvZiByZXN1bHRhbnQgZ3JhZGUgaXMgMC40MzQ1OTlcIlxuIn0= -->

```
[1] "The max probability of resultant grade is 0.434599"
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuc3ByaW50ZihcIlRoZSBtYXggZ3JhZGUgb2J0YWluZWQgd2l0aCBnaXZlbiBlY2lkZW5jZSBpcyAlcyBcIixyZXN1bHQpXG5gYGAifQ== -->

```r
sprintf("The max grade obtained with given ecidence is %s ",result)
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiWzFdIFwiVGhlIG1heCBncmFkZSBvYnRhaW5lZCB3aXRoIGdpdmVuIGVjaWRlbmNlIGlzIENEIFwiXG4ifQ== -->

```
[1] "The max grade obtained with given ecidence is CD "
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->

Q4(a): The last column in the data file indicates whether a student qualifies for an internship program or not. From the given data, take 70 percent data for training and build a naive Bayes classifier (considering that the grades earned in different courses are independent of each other) which takes in the student’s performance and returns the qualification status with a probability. Test your classifier on the remaining 30 percent data. Repeat this experiment for 20 random selection of training and testing data. Report results about the accuracy of your classifier.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldFxuc3BsaXQgPC0gc2FtcGxlLnNwbGl0KGRhdGFzZXRfZ3JhZGVzLCBTcGxpdFJhdGlvID0gMC43KSBcbnRyYWluIDwtIHN1YnNldChkYXRhc2V0X2dyYWRlcywgc3BsaXQgPT0gXCJUUlVFXCIpIFxudGVzdCA8LSBzdWJzZXQoZGF0YXNldF9ncmFkZXMsIHNwbGl0ID09IFwiRkFMU0VcIikgXG5uYWl2ZV9iYXllc19jbGFzc2lmaWVyPC0gbmFpdmVCYXllcyhRUCB+IC4sIGRhdGEgPSB0cmFpbilcbnlfdHJhaW49cHJlZGljdChuYWl2ZV9iYXllc19jbGFzc2lmaWVyLCBuZXdkYXRhID0gdHJhaW4pXG55X3ByZWRpY3Rpb24gPC0gcHJlZGljdChuYWl2ZV9iYXllc19jbGFzc2lmaWVyLCBuZXdkYXRhID0gdGVzdClcbmNtX3RyYWluPC0gdGFibGUodHJhaW4kUVAsIHlfdHJhaW4pXG5hY2N1cmFjeV90cmFpbiA9IChjbV90cmFpblsxLDFdK2NtX3RyYWluWzIsMl0pL3N1bShjbV90cmFpbilcbnByaW50KHJvdW5kKGNiaW5kKFwiVHJhaW4gQWNjdXJhY3lcIiA9YWNjdXJhY3lfdHJhaW4pLCA0KSlcbmBgYCJ9 -->

```r
dataset_grades=dataset
split <- sample.split(dataset_grades, SplitRatio = 0.7) 
train <- subset(dataset_grades, split == "TRUE") 
test <- subset(dataset_grades, split == "FALSE") 
naive_bayes_classifier<- naiveBayes(QP ~ ., data = train)
y_train=predict(naive_bayes_classifier, newdata = train)
y_prediction <- predict(naive_bayes_classifier, newdata = test)
cm_train<- table(train$QP, y_train)
accuracy_train = (cm_train[1,1]+cm_train[2,2])/sum(cm_train)
print(round(cbind("Train Accuracy" =accuracy_train), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUcmFpbiBBY2N1cmFjeVxuWzEsXSAgICAgICAgIDAuOTkzNVxuIn0= -->

```
     Train Accuracy
[1,]         0.9935
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuY21fdGVzdCA8LSB0YWJsZSh0ZXN0JFFQLCB5X3ByZWRpY3Rpb24pXG5hY2N1cmFjeV90ZXN0ID0gKGNtX3Rlc3RbMSwxXStjbV90ZXN0WzIsMl0pL3N1bShjbV90ZXN0KVxucHJpbnQocm91bmQoY2JpbmQoXCJUZXN0IEFjY3VyYWN5XCIgPWFjY3VyYWN5X3Rlc3QpLCA0KSlcbmBgYCJ9 -->

```r
cm_test <- table(test$QP, y_prediction)
accuracy_test = (cm_test[1,1]+cm_test[2,2])/sum(cm_test)
print(round(cbind("Test Accuracy" =accuracy_test), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUZXN0IEFjY3VyYWN5XG5bMSxdICAgICAgICAwLjkzNTFcbiJ9 -->

```
     Test Accuracy
[1,]        0.9351
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->

Q4(b): Repeat this experiment for 20 random selection of training and testing data. Report results about the accuracy of your classifier.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldFxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldF9ncmFkZXNbc2FtcGxlKG5yb3coZGF0YXNldF9ncmFkZXMpLCAyMCksIF1cbnNwbGl0IDwtIHNhbXBsZS5zcGxpdChkYXRhc2V0X2dyYWRlcywgU3BsaXRSYXRpbyA9IDAuNykgXG50cmFpbiA8LSBzdWJzZXQoZGF0YXNldF9ncmFkZXMsIHNwbGl0ID09IFwiVFJVRVwiKSBcbnRlc3QgPC0gc3Vic2V0KGRhdGFzZXRfZ3JhZGVzLCBzcGxpdCA9PSBcIkZBTFNFXCIpXG5uYWl2ZV9iYXllc19jbGFzc2lmaWVyPC0gbmFpdmVCYXllcyhRUCB+IC4sIGRhdGEgPSB0cmFpbilcbnlfdHJhaW49cHJlZGljdChuYWl2ZV9iYXllc19jbGFzc2lmaWVyLCBuZXdkYXRhID0gdHJhaW4pXG55X3ByZWRpY3Rpb24gPC0gcHJlZGljdChuYWl2ZV9iYXllc19jbGFzc2lmaWVyLCBuZXdkYXRhID0gdGVzdClcbmNtX3RyYWluPC0gdGFibGUodHJhaW4kUVAsIHlfdHJhaW4pXG5hY2N1cmFjeV90cmFpbiA9IChjbV90cmFpblsxLDFdK2NtX3RyYWluWzIsMl0pL3N1bShjbV90cmFpbilcbnByaW50KHJvdW5kKGNiaW5kKFwiVHJhaW4gQWNjdXJhY3lcIiA9YWNjdXJhY3lfdHJhaW4pLCA0KSlcbmBgYCJ9 -->

```r
dataset_grades=dataset
dataset_grades=dataset_grades[sample(nrow(dataset_grades), 20), ]
split <- sample.split(dataset_grades, SplitRatio = 0.7) 
train <- subset(dataset_grades, split == "TRUE") 
test <- subset(dataset_grades, split == "FALSE")
naive_bayes_classifier<- naiveBayes(QP ~ ., data = train)
y_train=predict(naive_bayes_classifier, newdata = train)
y_prediction <- predict(naive_bayes_classifier, newdata = test)
cm_train<- table(train$QP, y_train)
accuracy_train = (cm_train[1,1]+cm_train[2,2])/sum(cm_train)
print(round(cbind("Train Accuracy" =accuracy_train), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUcmFpbiBBY2N1cmFjeVxuWzEsXSAgICAgICAgICAgICAgMVxuIn0= -->

```
     Train Accuracy
[1,]              1
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuY21fdGVzdCA8LSB0YWJsZSh0ZXN0JFFQLCB5X3ByZWRpY3Rpb24pXG5hY2N1cmFjeV90ZXN0ID0gKGNtX3Rlc3RbMSwxXStjbV90ZXN0WzIsMl0pL3N1bShjbV90ZXN0KVxucHJpbnQocm91bmQoY2JpbmQoXCJUZXN0IEFjY3VyYWN5XCIgPWFjY3VyYWN5X3Rlc3QpLCA0KSlcbmBgYCJ9 -->

```r
cm_test <- table(test$QP, y_prediction)
accuracy_test = (cm_test[1,1]+cm_test[2,2])/sum(cm_test)
print(round(cbind("Test Accuracy" =accuracy_test), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUZXN0IEFjY3VyYWN5XG5bMSxdICAgICAgICAwLjgzMzNcbiJ9 -->

```
     Test Accuracy
[1,]        0.8333
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->


Q5(a): Repeat 4, considering that the grades earned in different courses may be dependent.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldFxuc3BsaXQgPC0gc2FtcGxlLnNwbGl0KGRhdGFzZXRfZ3JhZGVzLCBTcGxpdFJhdGlvID0gMC43KVxudHJhaW4gPC0gc3Vic2V0KGRhdGFzZXRfZ3JhZGVzLCBzcGxpdCA9PSBcIlRSVUVcIilcbnRlc3QgPC0gc3Vic2V0KGRhdGFzZXRfZ3JhZGVzLCBzcGxpdCA9PSBcIkZBTFNFXCIpXG50cmFpbi5oYz1zdXBwcmVzc1dhcm5pbmdzKGhjKHRyYWluLCBzY29yZT1cImsyXCIpKVxucGxvdCh0cmFpbi5oYylcbmBgYCJ9 -->

```r
dataset_grades=dataset
split <- sample.split(dataset_grades, SplitRatio = 0.7)
train <- subset(dataset_grades, split == "TRUE")
test <- subset(dataset_grades, split == "FALSE")
train.hc=suppressWarnings(hc(train, score="k2"))
plot(train.hc)
```

<!-- rnb-source-end -->

<!-- rnb-plot-begin eyJoZWlnaHQiOjQzMi42MzI5LCJ3aWR0aCI6NzAwLCJzaXplX2JlaGF2aW9yIjowLCJjb25kaXRpb25zIjpbXX0= -->

<img src="data:image/png;base64,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" />

<!-- rnb-plot-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxubmFpdmVfYmF5ZXNfY2xhc3NpZmllcjwtIHN1cHByZXNzV2FybmluZ3MoYm4uZml0KHRyYWluLmhjLCB0cmFpbikpXG55X3RyYWluIDwtIHByZWRpY3QobmFpdmVfYmF5ZXNfY2xhc3NpZmllcixub2RlPVwiUVBcIiwgZGF0YSA9IHRyYWluKVxueV9wcmVkaWN0aW9uIDwtIHByZWRpY3QobmFpdmVfYmF5ZXNfY2xhc3NpZmllcixub2RlPVwiUVBcIiwgZGF0YSA9IHRlc3QpXG5jbV90cmFpbjwtIHRhYmxlKHRyYWluJFFQLCB5X3RyYWluKVxuYWNjdXJhY3lfdHJhaW4gPSAoY21fdHJhaW5bMSwxXStjbV90cmFpblsyLDJdKS9zdW0oY21fdHJhaW4pXG5wcmludChyb3VuZChjYmluZChcIlRyYWluIEFjY3VyYWN5XCIgPWFjY3VyYWN5X3RyYWluKSwgNCkpXG5gYGAifQ== -->

```r
naive_bayes_classifier<- suppressWarnings(bn.fit(train.hc, train))
y_train <- predict(naive_bayes_classifier,node="QP", data = train)
y_prediction <- predict(naive_bayes_classifier,node="QP", data = test)
cm_train<- table(train$QP, y_train)
accuracy_train = (cm_train[1,1]+cm_train[2,2])/sum(cm_train)
print(round(cbind("Train Accuracy" =accuracy_train), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUcmFpbiBBY2N1cmFjeVxuWzEsXSAgICAgICAgIDAuOTA5MVxuIn0= -->

```
     Train Accuracy
[1,]         0.9091
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuY21fdGVzdCA8LSB0YWJsZSh0ZXN0JFFQLCB5X3ByZWRpY3Rpb24pXG5hY2N1cmFjeV90ZXN0ID0gKGNtX3Rlc3RbMSwxXStjbV90ZXN0WzIsMl0pL3N1bShjbV90ZXN0KVxucHJpbnQocm91bmQoY2JpbmQoXCJUZXN0IEFjY3VyYWN5XCIgPWFjY3VyYWN5X3Rlc3QpLCA0KSlcbmBgYCJ9 -->

```r
cm_test <- table(test$QP, y_prediction)
accuracy_test = (cm_test[1,1]+cm_test[2,2])/sum(cm_test)
print(round(cbind("Test Accuracy" =accuracy_test), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUZXN0IEFjY3VyYWN5XG5bMSxdICAgICAgICAwLjkzNTlcbiJ9 -->

```
     Test Accuracy
[1,]        0.9359
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->


<!-- rnb-text-begin -->

Q5(b): Repeat this experiment for 20 random selection of training and testing data. Report results about the accuracy of your classifier.

<!-- rnb-text-end -->


<!-- rnb-chunk-begin -->


<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldFxuZGF0YXNldF9ncmFkZXM9ZGF0YXNldF9ncmFkZXNbc2FtcGxlKG5yb3coZGF0YXNldF9ncmFkZXMpLCAyMCksIF1cbnNwbGl0IDwtIHNhbXBsZS5zcGxpdChkYXRhc2V0X2dyYWRlcywgU3BsaXRSYXRpbyA9IDAuNykgXG50cmFpbiA8LSBzdWJzZXQoZGF0YXNldF9ncmFkZXMsIHNwbGl0ID09IFwiVFJVRVwiKSBcbnRlc3QgPC0gc3Vic2V0KGRhdGFzZXRfZ3JhZGVzLCBzcGxpdCA9PSBcIkZBTFNFXCIpXG50cmFpbi5oYz1zdXBwcmVzc1dhcm5pbmdzKGhjKHRyYWluLCBzY29yZT1cImsyXCIpKVxucGxvdCh0cmFpbi5oYylcbmBgYCJ9 -->

```r
dataset_grades=dataset
dataset_grades=dataset_grades[sample(nrow(dataset_grades), 20), ]
split <- sample.split(dataset_grades, SplitRatio = 0.7) 
train <- subset(dataset_grades, split == "TRUE") 
test <- subset(dataset_grades, split == "FALSE")
train.hc=suppressWarnings(hc(train, score="k2"))
plot(train.hc)
```

<!-- rnb-source-end -->

<!-- rnb-plot-begin eyJoZWlnaHQiOjQzMi42MzI5LCJ3aWR0aCI6NzAwLCJzaXplX2JlaGF2aW9yIjowLCJjb25kaXRpb25zIjpbXX0= -->

<img src="data:image/png;base64,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" />

<!-- rnb-plot-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxubmFpdmVfYmF5ZXNfY2xhc3NpZmllcjwtIHN1cHByZXNzV2FybmluZ3MoYm4uZml0KHRyYWluLmhjLCB0cmFpbikpXG55X3RyYWluIDwtIHByZWRpY3QobmFpdmVfYmF5ZXNfY2xhc3NpZmllcixub2RlPVwiUVBcIiwgZGF0YSA9IHRyYWluKVxueV9wcmVkaWN0aW9uIDwtIHByZWRpY3QobmFpdmVfYmF5ZXNfY2xhc3NpZmllcixub2RlPVwiUVBcIiwgZGF0YSA9IHRlc3QpXG5jbV90cmFpbjwtIHRhYmxlKHRyYWluJFFQLCB5X3RyYWluKVxuYWNjdXJhY3lfdHJhaW4gPSAoY21fdHJhaW5bMSwxXStjbV90cmFpblsyLDJdKS9zdW0oY21fdHJhaW4pXG5wcmludChyb3VuZChjYmluZChcIlRyYWluIEFjY3VyYWN5XCIgPWFjY3VyYWN5X3RyYWluKSwgNCkpXG5gYGAifQ== -->

```r
naive_bayes_classifier<- suppressWarnings(bn.fit(train.hc, train))
y_train <- predict(naive_bayes_classifier,node="QP", data = train)
y_prediction <- predict(naive_bayes_classifier,node="QP", data = test)
cm_train<- table(train$QP, y_train)
accuracy_train = (cm_train[1,1]+cm_train[2,2])/sum(cm_train)
print(round(cbind("Train Accuracy" =accuracy_train), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUcmFpbiBBY2N1cmFjeVxuWzEsXSAgICAgICAgIDAuODU3MVxuIn0= -->

```
     Train Accuracy
[1,]         0.8571
```



<!-- rnb-output-end -->

<!-- rnb-source-begin eyJkYXRhIjoiYGBgclxuY21fdGVzdCA8LSB0YWJsZSh0ZXN0JFFQLCB5X3ByZWRpY3Rpb24pXG5hY2N1cmFjeV90ZXN0ID0gKGNtX3Rlc3RbMSwxXStjbV90ZXN0WzIsMl0pL3N1bShjbV90ZXN0KVxucHJpbnQocm91bmQoY2JpbmQoXCJUZXN0IEFjY3VyYWN5XCIgPWFjY3VyYWN5X3Rlc3QpLCA0KSlcbmBgYCJ9 -->

```r
cm_test <- table(test$QP, y_prediction)
accuracy_test = (cm_test[1,1]+cm_test[2,2])/sum(cm_test)
print(round(cbind("Test Accuracy" =accuracy_test), 4))
```

<!-- rnb-source-end -->

<!-- rnb-output-begin eyJkYXRhIjoiICAgICBUZXN0IEFjY3VyYWN5XG5bMSxdICAgICAgICAwLjY2NjdcbiJ9 -->

```
     Test Accuracy
[1,]        0.6667
```



<!-- rnb-output-end -->

<!-- rnb-chunk-end -->

