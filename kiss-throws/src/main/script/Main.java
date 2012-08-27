import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author marvin.froeder
 */
public class Main
{

    public static void main( String[] args )
        throws Exception
    {
        ClassReader cr =
            new ClassReader(
                             new FileInputStream(
                                                  "C:/Users/marvin.froeder.CONSISTEM/workspace/cleanutils/silentthrow/target/classes/com/marvinformatics/cleanutils/silentthrow/Throws.class" ) );

        int flags = ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES;

        cr.accept( new TraceClassVisitor( null, new ASMifier(), new PrintWriter( System.out ) ), flags );
    }
}
