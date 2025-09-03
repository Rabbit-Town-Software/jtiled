package org.rabbittownsoftware.jtiled;

import java.util.logging.Logger;

/**
 * Represents a tileset definition in a Tiled map (.tmx or .tsx).
 *
 * <p>
 * A TiledTileset links a tileset image to a first global ID (firstGID),
 * allowing maps to determine which tileset a given tile ID belongs to.
 * </p>
 *
 * <p>
 * Unlike earlier versions, this class does <b>not</b> load or hold image
 * data directly. Instead, it keeps metadata such as:
 * <ul>
 *     <li><b>source</b> - Path to the tileset image as defined in Tiled.</li>
 *     <li><b>firstGID</b> - The global tile ID offset for this tileset.</li>
 *     <li><b>tileWidth</b> - Width of each tile (in pixels).</li>
 *     <li><b>tileHeight</b> - Height of each tile (in pixels).</li>
 *     <li><b>tileCount</b> - Total number of tiles in this tileset.</li>
 *     <li><b>columns</b> - Number of tile columns in the image.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Consumers of this library can use {@code source} to load the image
 * with their preferred rendering framework (e.g., Java AWT, LibGDX, LWJGL).
 * </p>
 */
@SuppressWarnings("unused")
public class TiledTileset
{
    private static final Logger LOGGER = Logger.getLogger(TiledTileset.class.getName());

    private final String source;    // File path to the tileset image
    private final int firstGID;     // First Global Tile ID for this tileset
    private final int tileWidth;    // Width of each tile in pixels
    private final int tileHeight;   // Height of each tile in pixels
    private final int tileCount;    // Number of tiles in this tileset
    private final int columns;      // Columns in the tileset image

    /**
     * Creates a new TiledTileset with the specified metadata.
     *
     * @param source     Path to the tileset image (relative or absolute).
     * @param firstGID   The first global tile ID associated with this tileset.
     * @param tileWidth  Width of each tile in pixels.
     * @param tileHeight Height of each tile in pixels.
     * @param tileCount  Total number of tiles in this tileset.
     * @param columns    Number of columns in the tileset image.
     */
    public TiledTileset(String source,
                        int firstGID,
                        int tileWidth,
                        int tileHeight,
                        int tileCount,
                        int columns)
    {
        this.source = source;
        this.firstGID = firstGID;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tileCount = tileCount;
        this.columns = columns;

        LOGGER.info("Created TiledTileset: " + source +
                " (firstGID=" + firstGID +
                ", tiles=" + tileCount +
                ", tileSize=" + tileWidth + "x" + tileHeight + ")");
    }

    /**
     * Checks if this tileset contains the given global tile ID.
     *
     * @param tileID The global tile ID to check.
     * @return True if the tile ID is within this tileset's range.
     */
    public boolean containsTile(int tileID)
    {
        return tileID >= firstGID && tileID < firstGID + tileCount;
    }

    // ----------- Getters -----------

    /** @return Path to the tileset image. */
    public String getSource()
    {
        return source;
    }

    /** @return First global tile ID for this tileset. */
    public int getFirstGID()
    {
        return firstGID;
    }

    /** @return Tile width in pixels. */
    public int getTileWidth()
    {
        return tileWidth;
    }

    /** @return Tile height in pixels. */
    public int getTileHeight()
    {
        return tileHeight;
    }

    /** @return Total number of tiles in this tileset. */
    public int getTileCount()
    {
        return tileCount;
    }

    /** @return Number of columns in the tileset image. */
    public int getColumns()
    {
        return columns;
    }
}
