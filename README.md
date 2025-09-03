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
for (TiledLayer layer : map.getLayers()) {
    System.out.println("Layer: " + layer.name());
}
```

---

## Notes
- Supports **CSV** + **Base64 (uncompressed)** tile encodings.
- Object properties are parsed as strings.
- Compressed base64 layers (zlib/gzip) are not yet supported.
