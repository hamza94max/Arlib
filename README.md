# Arlib APP

it's an android app using jetcompose to get data from api, caching it 

## Architecture
The architecture of this application relies and complies with the following points below:
- __Clean Architecture__,: into 3 layers ui, data, domain
- __Pattern Model-View-ViewModel (MVVM)__ which facilitates a separation of development of the graphical user interface.
- __Android architecture components__ which help to keep the application robust, testable, and maintainable.

![Capture](https://github.com/hamza94max/Football-League-App/assets/54688005/317d0417-bf8a-4fa9-895e-b13c24d1f374)

## ScreenShots

 <table>
  <tr>
    <th>Login Screen </th>
    <th>Home Screen</th>
    <th>Details Screen</th>
  </tr>
  <tr>
    <td><img src="https://github.com/hamza94max/Arlib/assets/54688005/e0aca5fd-866c-4f70-b6d1-a2886bf8e6b4" width="350"></td>
    <td><img src="https://github.com/hamza94max/Arlib/assets/54688005/7674e796-e552-4739-93d9-87bbf4323580" width="350"></td>
    <td><img src="https://github.com/hamza94max/Arlib/assets/54688005/51aed65a-a4b6-4520-80e7-b7e64d20b292" width="350"></td>
  </tr>
 </table>


# Languages and Tools
* [Kotlin](https://kotlinlang.org/) - official programming language for Android development .
* [JetCompose](https://developer.android.com/develop/ui/compose) -  modern toolkit for building native UI. .
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection library .
* [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - for asynchronous programming .
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Room DataBase](https://developer.android.com/topic/libraries/architecture/room) - Access your app's SQLite database with in-app objects and compile-time checks.

# Unit Testing

<img src="https://github.com/hamza94max/Arlib/assets/54688005/c5ee6840-3159-4b2e-979b-7f06f69931e8" height="300" width="75%"/>


# Api
The base URL ==> `https://run.mocky.io/v3/` with endPoint `5aef18d7-961c-4327-8eb6-102d51287f30`

`The response`

```json
{
    "drugs": [{
            "name": "aspirin",
            "dose": "1 tablet",
            "strength": "500 mg"
        },
        {
            "name": "ibuprofen",
            "dose": "1 tablet",
            "strength": "200 mg"
        },
        {
            "name": "paracetamol",
            "dose": "1 tablet",
            "strength": "500 mg"
        },
        {
            "name": "omeprazole",
            "dose": "1 capsule",
            "strength": "20 mg"
        }
    ]
}
```


