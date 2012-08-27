import java.util.*;
import org.objectweb.asm.*;
import org.objectweb.asm.attrs.*;
import java.io.*;
import static org.objectweb.asm.Opcodes.*;


def cw = new ClassWriter(0);
def fv;
def mv;
def av0;

cw.visit(V1_5, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, "com/marvinformatics/kissthrow/Throws", null, "java/lang/Object", null);

cw.visitSource("Throws.java", null);

mv = cw.visitMethod(ACC_PRIVATE, "<init>", "()V", null, null);
mv.visitCode();
mv.visitVarInsn(ALOAD, 0);
mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
mv.visitInsn(RETURN);
mv.visitMaxs(1, 1);
mv.visitEnd();


mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "silentThrow", "(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;", null, null );
mv.visitCode();
def l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(24, l0);
mv.visitVarInsn(ALOAD, 0);
mv.visitInsn(ATHROW);
def l1 = new Label();
mv.visitLabel(l1);
mv.visitLocalVariable("throwableElement", "Ljava/lang/Throwable;", null, l0, l1, 0);
mv.visitMaxs(1, 1);
mv.visitEnd();


mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
mv.visitCode();
mv.visitTypeInsn(NEW, "com/marvinformatics/kissthrow/Throws");
mv.visitInsn(DUP);
mv.visitMethodInsn(INVOKESPECIAL, "com/marvinformatics/kissthrow/Throws", "<init>", "()V");
mv.visitInsn(POP);
mv.visitInsn(RETURN);
mv.visitMaxs(2, 0);
mv.visitEnd();

cw.visitEnd();

def classOut = new File( project.build.outputDirectory, "com/marvinformatics/kissthrow/Throws.class"); 
def out = new FileOutputStream( classOut );
out.write(cw.toByteArray());
out.flush();
out.close();
