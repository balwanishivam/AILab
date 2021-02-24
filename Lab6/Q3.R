#install.packages("mclust")
# install.packages("stats")
# install.packages("factoextra")
library(mclust)  
library(stats)
library(factoextra)
library(EMCluster)
par(mfrow = c(2, 1))
data = read.table("C:/Users/shiva/OneDrive/Desktop/Semester-6/AILab/Lab6/2020_em_clustering.csv",sep = ',')
data<-as.data.frame(t(data))
x=data$V1
model <- Mclust(data, G = 2)
summary(model)
mclust1Dplot(x, parameters = model$parameters, z = model$z, 
             what = "classification",xlab="x")

##K Means
(model2<-kmeans(data,2))
da<-model2$cluster
plot(x,col=model2$cluster)


