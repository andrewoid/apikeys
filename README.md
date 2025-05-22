## ApiKey

This library simplifies retrieval of api keys when stored locally and on GitHub.

### Dependency

``` groovy
implementation 'com.andrewoid:apikeys:0.4'
```

### Usage

```java
ApiKey apiKey = new ApiKey();
String keyString = apiKey.get();
```

### Storing API Keys Locally

Make sure your `.gitignore` includes this line

``` gitignore
**/apikey.properties
```

Create a file `src/main/resources/apikey.properties` in your project. This file must **NOT** be checked into git.

```
apikey=ApiKeyGivenToYouByTheApiWhenYouSignUp
```

### Storing API Keys on GitHub

1. Open your Repository on GitHub and go to `Settings`

2. In `Secrets and Variables` add a new Repository Secret called `APIKEY`. The value should be the API key that was
   given to you by the service.

![add secret github](images/add_secret.png)

### Accessing API Keys with GitHub Actions

Pass the API key as an environment variable to your `.yaml` file as shown below.

``` yaml
env:
    apikey: ${{ secrets.APIKEY }}
```

![pass api key as an environment variable](images/add_key.png)

### Accessing more than one API Key

If your application needs more than one API Key you can name it something specific in your `apikey.properties`.

```
apikey1=ApiKeyGivenToYouByTheApiWhenYouSignUp
apikey2=SecondApiKeyGivenToYouByTheOtherApi
```

You can retrieve them by

```java
ApiKey apiKey1 = new ApiKey("apikey1");
String keyString1 = apiKey1.get();

ApiKey apiKey2 = new ApiKey("apikey2");
String keyString2 = apiKey2.get();
```

You will need to add **two** secrets to GitHub with **two** entries in your `.yaml` file



