private void runTextRecognition() {
   InputImage image = InputImage.fromBitmap(mSelectedImage, 0);
   TextRecognizer recognizer = TextRecognition.getClient();
   mTextButton.setEnabled(false);
   recognizer.process(image)
           .addOnSuccessListener(
                   new OnSuccessListener<Text>() {
                       @Override
                       public void onSuccess(Text texts) {
                           mTextButton.setEnabled(true);
                           processTextRecognitionResult(texts);
                       }
                   })
           .addOnFailureListener(
                   new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           // Task failed with an exception
                           mTextButton.setEnabled(true);
                           e.printStackTrace();
                       }
                   });
}