Clojure on Google App Engine: Hello World
=========================================

This is a sample project that showcases how to deploy a Clojure web application into [Google App Engine].

**NOTE**: See all the files in this repository for comments regarding the various fiddly bits (`app.yaml` in particular).

## Prerequisites

You must have these command-line tools installed:

- [Clojure command-line tool]
- [gcloud command-line tool]

Additionally, before continuing, you must:
 
- [Authorize Google Cloud SDK Tools](https://cloud.google.com/sdk/docs/authorizing)
- Create a new project via [the GCP console](https://console.cloud.google.com/) (note the project ID)

## Steps

These steps assume the project ID of your GCP project is `foo-bar-123456`.
Replace the ID with your own project ID when running these commands.

There are other ways of specifying the project ID. See the [gcloud CLI docs][gcloud command-line tool].

1. Create new App Engine app:

    ```bash
    $ gcloud app create --project=foo-bar-123456
    ```
   
   In the prompt that appears, select the region where you want to deploy the app.

1. Create an uberjar:

    ```bash
    $ clj -A:uberjar
    ```

1. Copy `app.yaml` into the `target` directory:

    ```bash
    $ cp app.yaml target
    # This seems a bit inelegant, but I haven't figured out a better way.
    ```

1. Deploy the application:

    ```bash
    $ gcloud app deploy --project=foo-bar-123456 target
    ```

1. Open the app in your browser:

    ```bash
   $ gcloud app browse --project=foo-bar-123456
   ```

    The first request's gonna take a while.

[Google App Engine]: https://cloud.google.com/appengine/
[Clojure command-line tool]: https://clojure.org/guides/getting_started
[gcloud command-line tool]: https://cloud.google.com/sdk/gcloud/

