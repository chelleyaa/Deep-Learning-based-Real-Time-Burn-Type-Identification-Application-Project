# Deep-Learning-based-Real-Time-Burn-Type-Identification-Application-Project
A deep learning-based Android application designed for the real-time identification and classification of burn wound severity. The app integrates a lightweight MobileNetV4 model and leverages Firebase for backend services.

# About The Project
This project is an Android application developed to assist in the rapid classification of burn injuries directly from a mobile device's camera. By integrating a highly efficient MobileNetV4 deep learning model, the app provides immediate, on-device analysis of a potential burn wound, classifying it into one of three categories.

The primary goal is to provide a fast, accessible, and reliable decision-support tool for medical professionals in high-pressure environments, helping to streamline the initial assessment process.

Classification Categories
The model classifies wounds into three distinct types:
1. 1st Degree Burn
2. 2nd Degree Burn
3. 3rd Degree Burn

# Key Features
1. Real-Time Classification: Uses the live camera feed to identify burn types instantly.
2. On-Device Deep Learning: Employs a MobileNetV4 model (converted to TensorFlow Lite) for efficient inference without needing a server connection.
3. User Authentication: Secure user registration and login functionality powered by Firebase Authentication.
4. Cloud Storage: Allows users to capture and upload images of burn wounds to Firebase Cloud Storage for record-keeping or further review.
5. Intuitive UI: A clean and straightforward user interface designed for quick and easy use in a clinical setting.

# Target Audience & Use Case
This application is specifically designed for medical student clinical rotation in the Emergency Room (ER).
In the fast-paced ER environment, interns often need to make quick assessments. This app serves as a preliminary diagnostic aid, offering an objective, data-driven classification of a burn's severity. It is intended to be a decision-support tool to supplement, not replace, professional medical evaluation and expertise.

# Technology Stack
1. Mobile Development: Java, Android Studio
2. Deep Learning: TensorFlow Lite, MobileNetV4
3. Backend Services: Firebase Authentication, Firebase Cloud Storage
4. Dataset Provider: Roboflow

# Perfomance Highlights
✔️ High Accuracy: The MobileNet model identifies burn types with an accuracy of 94.7%.

⚡ Fast Identification: Image classification is performed in under 5 seconds, enabling rapid assessment.

📱 Wide Compatibility: The application is optimized to run smoothly on Android devices with a minimum version of Android 6.0 (Marshmallow).
