Clojure on Google App Engine: Hello World
=========================================

This is a sample project that showcases how to deploy a Clojure web application into [Google App Engine].

**NOTE**: See all the files in this repository for comments regarding the various fiddly bits (`app.yaml` in particular).

## Prerequisites

You must have these command-line tools installed:

- [Leiningen]
- [gcloud command-line tool]

Additionally, before continuing, you must [authorize Google Cloud SDK Tools](https://cloud.google.com/sdk/docs/authorizing).

## Steps

These steps assume the project ID of your GCP project is `foo-bar-123456`.
Replace the ID with your own project ID when running these commands.

There are other ways of specifying the project ID. See the [gcloud CLI docs][gcloud command-line tool].

1. Create new Google Cloud Platform project:

    ```bash
    $ gcloud projects create foo-bar-123456
    ```

1. Create new App Engine app:

    ```bash
    $ gcloud app create --project=foo-bar-123456
    ```
   
   In the prompt that appears, select the region where you want to deploy the app.

1. Create an uberjar:

    ```bash
    $ lein uberjar
    $ mkdir -p target/staging
    $ cp target/hello-world.jar target/staging
    # The gcloud CLI deploys all the files in the deployable directory, so we want
    # to copy the uberjar into a directory without any other files.
    ```

1. Copy `app.yaml` into the staging directory:

    ```bash
    $ cp app.yaml target/staging
    # This seems a bit inelegant, but I haven't figured out a better way.
    #
    # This is necessary because app.yaml and the deployable artifact need
    # to be in the same directory.
    ```

1. Deploy the application:

    ```bash
    $ gcloud app deploy --project=foo-bar-123456 target/staging
    ```

1. Open the app in your browser:

    ```bash
   $ gcloud app browse --project=foo-bar-123456
   ```

    The first request's gonna take a while.

[Google App Engine]: https://cloud.google.com/appengine/
[Leiningen]: https://leiningen.org
[gcloud command-line tool]: https://cloud.google.com/sdk/gcloud/

