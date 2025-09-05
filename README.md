# JTiled

**JTiled** is a lightweight Java library for parsing [Tiled](https://www.mapeditor.org/) `.tmx` maps.  
It is designed to be **simple, dependency-free, and ready to drop into any project**.

---

## Features
- Parse `.tmx` maps from filesystem or classpath.
- Supports **inline** and **external** tilesets (`.tsx`).
- Handles:
    - **Tile layers** (CSV + Base64 encoding)
    - **Object layers** (IDs, names, types, positions, properties)
- Immutable API via `TiledMap.Builder`.
- Ships with **sources** + **javadoc jars** for IDE integration.
- No rendering dependencies.

---

## Installation

### Option 1 – Manual JAR
Download the latest [release](https://github.com/Rabbit-Town-Software/jtiled/releases) and add it to your project.

**Gradle**
```gradle
implementation files('libs/jtiled-1.0.0.jar')
```

**Maven (local install)**
```bash
mvn install:install-file   -Dfile=jtiled-1.0.0.jar   -DgroupId=org.rabbittownsoftware   -DartifactId=jtiled   -Dversion=1.0.0   -Dpackaging=jar
```

### Option 2 – Source & Javadoc
Include `jtiled-1.0.0-sources.jar` and `jtiled-1.0.0-javadoc.jar` for inline docs in your IDE.

---

## Example Usage

```java
import org.rabbittownsoftware.jtiled.*;

TiledParser parser = new TiledParser(Collections.emptyList());
TiledMap map = parser.loadFromTMX("example.tmx");

System.out.println("Map size: " + map.getWidth() + " x " + map.getHeight());
for (TiledLayer layer : map.getLayers())
{
    System.out.println("Layer: " + layer.name());
}
```

---

## Notes
- Supports **CSV** + **Base64 (uncompressed)** tile encodings.
- Object properties are parsed as strings.
- Compressed base64 layers (zlib/gzip) are not yet supported.

---

## License

JTiled is licensed under the **GNU General Public License v3.0 (GPL-3.0)**.  
You are free to use, modify, and distribute the code, as long as any modified versions remain under the same license.

- ✔️ Commercial use allowed
- ✔️ Modifications allowed
- ✔️ Distribution allowed
- ❗ Derivative works must also be GPL-3.0 licensed

---

## Contact

Questions, bug reports, or feature requests?  
- Email: [support@rabbittownsoftware.com](mailto:support@rabbittownsoftware.com)
- Or open an [issue!](https://github.com/Rabbit-Town-Software/jtiled/issues/new)

---

## Rabbit Town Software

<br/>

<p align="center">
  <img src="https://github.com/Rabbit-Town-Software/misa-engine/blob/eb3aa63bad02385d2af4b7b130d1bde70e2a2715/assets/rabbittownlogo.jpg?raw=true" alt="Rabbit Town Software Logo" width="180"/>
</p>

<p align="center">
  <strong>Rabbit Town Software</strong><br/>
  Open-source. No compromise.
</p>

