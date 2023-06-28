import tensorflow as tf
# Load the SavedModel
model = tf.saved_model.load('C:/Users/HP/Downloads/cartoon.pt')

# Convert the model to TFLite format
converter = tf.lite.TFLiteConverter.from_saved_model('C:/Users/HP/Downloads')
tflite_model = converter.convert()

# Save the TFLite model to a file
with open('C:/Users/HP/Downloadsmodel.tflite', 'wb') as f:
    f.write(tflite_model)