# notimeout

notimeout is a small server-side NeoForge mod for Minecraft 1.21.1 and 26.3.

It increases the server login, keep-alive, and network read timeout limits. This gives players more time to finish joining the server before Minecraft disconnects them for taking too long.

This can help players with weaker PCs, slow storage, heavy modpacks, or unstable connections, especially when joining a large modded server.

## Details

- Minecraft: 1.21.1 or 26.3. Use the JAR built for your Minecraft version.
- Loader: NeoForge
- Side: server only
- Clients do not need to install this mod

The timeout value can be changed in `config/notimeout-common.toml`.

## Build

- Minecraft 1.21.1 (Java 21) — `./gradlew build`
- Minecraft 26.3 (Java 25) — `./gradlew build -PtargetMinecraft=26.3`
