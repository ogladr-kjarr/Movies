# Movies 

This repo is a very basic use of Java to learn how to model objects as classes, create interfaces, use lambdas
and method references, use JUnit, and to work with databases for storing and retrieving data.

# Data

The data comes from the [Kaggle Movie Set](https://www.kaggle.com/datasets/rounakbanik/the-movies-dataset), and has
been processed to replace the commas separating columns with '|' characters. This was because I didn't know another
way to stop the comma separation with JSON columns being included in the split command. The processing script is in the
main resources folder and uses R, as readr correctly recongnised the JSON objects as entries in a column.

To work with the project, download the data, run it through the DatExplorer.R script, and place the data files in the 
src/main/resources folder.