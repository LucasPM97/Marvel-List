# Marvel-List

## ApiKeys
The app will not work without the correct implementation of the api keys. To add them you should just add a **"apikey.properties"** file using your [Marvel Documentation keys](https://developer.marvel.com/account) :

```
CONSUMER_KEY="<Marvel Public Api key>"
CONSUMER_SECRET="<Marvel Private Api key>"
```

### Know-issues

- Loading : The ProgressBar should appear on the top of the screen only if is the first time the screen is loaded, and it should appear on the bottom of the screen when the user tries to get more items.
- Toolbar title: The Toolbar title should be centered.
- Character Details back button: The back button icon on the Character Details screen is not the one defined in the design.
