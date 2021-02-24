% Question-2 Lab-6
% Author: QuickFixDemos
% Date: February 23, 2021
% 
% Ten bent coins, Unknown Biases, Equally likely to get selected for tossing
% Given T observation sequences 
% Parameter learning using Expectation maximization
%
% Reference: What is expectation maximization algorithm? Chuong B Do and Serafim Batzoglou, Nature Biotechnology, Vol 26, Num 8, Aug 2008

clear all;
close all;

%y=csvread("two_bent_coins.csv");
y=csvread("2020_ten_bent_coins.csv");

% True Parameters
% theta = [.2 .5];
theta=rand(1,10);
disp(size(theta));
##theta1 = [.2 .5];
##disp(size(theta1));
##
h = sum(y,2); t = 100-h;
th(1,:) = theta;
#
for n=2:500
LH=zeros(size(h));
for k=1:10
  lh(:,k) = (th(n-1,k).^h).*((1-th(n-1,k)).^t);
  LH=LH+lh(:,k);
 end
for k=1:10
  th(n,k)=sum(h.*lh(:,k)./LH)/sum((h+t).*lh(:,k)./LH);
 end
end
disp("Initial Theta");
disp(theta);
disp("New Theta");
disp(th(500,:));
