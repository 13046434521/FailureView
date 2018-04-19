# FailureDemo
## FailureView
* 使用方法：项目Gradle：
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* App Gradle：
  ```java
    implementation('com.github.13046434521:FailureView:1.0') {
        exclude group: 'com.android.support'
    }
```
