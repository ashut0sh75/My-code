# Set the file path
file_path <- "Data Analytics/dataset/Training.csv"

# Read the CSV file
data <- read.csv(file_path)

# Print the top 5 rows
print(head(data, n = 10))