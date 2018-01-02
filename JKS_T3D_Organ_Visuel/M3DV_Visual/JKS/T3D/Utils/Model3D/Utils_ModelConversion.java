package JKS.T3D.Utils.Model3D;

import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.export.binary.BinaryExporter;
import com.jme3.scene.Spatial;
import com.jme3.util.TangentBinormalGenerator;

import java.io.File;
import java.io.IOException;

public class Utils_ModelConversion
{

    private final AssetManager assetManager;

    public Utils_ModelConversion(final AssetManager assetManager) 
    {this.assetManager = assetManager;}

    public void convert(final File inputFile, final File outputFile, final boolean generateTangents) 
    {
        final String parentPath = inputFile.getParent();
        assetManager.registerLocator(parentPath, FileLocator.class);

        try 
        {
            final Spatial modelToImport = assetManager.loadModel(inputFile.getName());

            if (modelToImport != null) 
            {
                if (generateTangents) {
                    TangentBinormalGenerator.generate(modelToImport);
                }

                final BinaryExporter binaryExporter = new BinaryExporter();

                if (outputFile.getParentFile().exists() || outputFile.getParentFile().mkdirs()) {
                    try {
                        binaryExporter.save(modelToImport, outputFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } 
        finally 
        { assetManager.unregisterLocator(parentPath, FileLocator.class);}
    }
}
