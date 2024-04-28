# jioSaavn Plugin For Lavalink

- This is a plugin for [Lavalink](https://github.com/lavalink-devs/Lavalink)
- This plugin allows you to play songs from JioSaavn in your discord server.
- This plugin uses the [JioSaavn API](https://github.com/sumitkolhe/jiosaavn-api) to fetch songs.


# API

> [!NOTE]
> You need `Bun(1.0.26+)` or `Node.js(v18+)`

1. Clone the repository:

   ```sh
   git clone https://github.com/sumitkolhe/jiosaavn-api
   cd jiosaavn-api
   ```

2. Install the required dependencies:

   ```sh
   bun install
   ```

3. Launch the development server:

   ```sh
   bun run dev
   ```

## ☁️ Deploying Your Own Instance

You can easily deploy your own instance of the API by clicking the button below:

[![Deploy with Vercel](https://vercel.com/button)](https://vercel.com/new/clone?repository-url=https://github.com/sumitkolhe/jiosaavn-api)

> [!TIP]
> To ensure the API provides results in the intended language, configure the [Serverless Function Region](https://vercel.com/docs/concepts/functions/serverless-functions/regions) in Vercel to `Mumbai, India (South) - > bom1`.


## Advantages of Using JioSaavn

* No region-based content blocking (unlike Deezer and Yandex).
* A better alternative for playing mirrored audio sources not dependent on YouTube.
* Similar content library size as Spotify and Apple Music.
* Superior to Deezer as it doesn't require any decryption key and provides slightly higher bitrate audio than Deezer's 128KBPS MP3.

## Supported URLs and Queries
### JioSaavan
* `jssearch:animals architects`
* https://www.jiosaavn.com/song/apna-bana-le/ATIfejZ9bWw
* https://www.jiosaavn.com/album/bhediya/wSM2AOubajk_
* https://www.jiosaavn.com/artist/arijit-singh-songs/LlRWpHzy3Hk_
* https://www.jiosaavn.com/featured/jai-hanuman/8GIEhrr8clSO0eMLZZxqsA__



