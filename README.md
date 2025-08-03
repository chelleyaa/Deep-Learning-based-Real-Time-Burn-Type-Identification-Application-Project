# Deep-Learning-based-Real-Time-Burn-Type-Identification-Application-Project
An Android application designed to identify the severity of burn wounds in real-time using a deep learning model. This project is specifically targeted at junior doctors in high-pressure emergency room environments to provide rapid, reliable diagnostic support.

# The Problem
Burn injuries are a significant global health issue, causing an estimated 180,000 deaths annually, with a high prevalence in Africa and Southeast Asia. In an Emergency Room (ER) setting, the philosophy is "Time Saving is Live Saving," requiring medical personnel to make decisions that are both fast and effective to prevent fatal complications. Junior doctors, who are often on the front lines in the ER, are required to act quickly and precisely. However, a survey conducted for this project revealed a critical gap:
1. 71.4% of respondents have never used a medical app to assist in burn diagnosis.

2. Only 19% feel highly confident in diagnosing the severity of a burn wound on their own.

3. A significant majority believe a dedicated screening app would be very helpful to reduce the risk of manual error and increase the speed and efficiency of treatment.

# Solution
To address these challenges, we developed a real-time burn identification application powered by a deep learning model. The application uses a smartphone's camera to analyze a wound and provide an immediate classification of its severity.
The primary mission is to accelerate burn wound treatment time and assist junior doctors in making critical clinical decisions by providing a reliable, on-the-spot diagnostic tool.

# Key Features
1. Real-Time Classification: Utilizes the device camera to identify the degree of a burn instantly, without the need for manual data entry.
2. Deep Learning-Powered Diagnosis: Integrates a deep learning algorithm to ensure high accuracy in classification.
3. First-Aid Recommendations: After identifying the burn's severity, the app provides corresponding first-aid and treatment recommendations.
4. Senior Doctor Consultation: For severe cases (3rd and 4th-degree burns), the application includes a feature to facilitate contact with a senior doctor for consultation.
5. Intuitive User Interface: Designed with a simple, responsive, and clear UI to be easily operated in the stressful and fast-paced ER environment.

# Technology Stack
1. Mobile Platform: Android
2. Programming Language: Java
3. Deep Learning : TensorFlow Lite, MobileNetV4
4. User Interface: Android Studio UI toolkit
5. Backend Services: Firebase Authentication, Firebase Cloud Storag

# Perfomance Highlights
✔️ High Accuracy: The MobileNet model identifies burn types with an accuracy of 94.7%.

⚡ Fast Identification: Image classification is performed in under 5 seconds, enabling rapid assessment.

📱 Wide Compatibility: The application is optimized to run smoothly on Android devices with a minimum version of Android 6.0 (Marshmallow).
