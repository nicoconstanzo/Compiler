package compiler;

import compiler.tree.*;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.RecognitionException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.io.*;
import java.util.Stack;

/**
 *
 */
public class Compiler {
    public static void main(String[] args)
        throws IOException, RecognitionException
    {
        Compiler compiler = new Compiler();

        // Validate arguments
        if (args.length == 0) {
            System.out.println("Please, specify some files to compile...");
            System.exit(1);
        }

        // Process each file
        for (String arg : args) {
            FileReader file = new FileReader(arg);
            try {
                Node ast = compiler.parse(file, true);
                System.out.println("TREE:\n" + ast + "\n");
                ast.analyze(new SymbolTable());
//                ast.execute(new Stack<Object>() {
//                    @Override
//                    public Object push(Object o) {
//                        if (o instanceof Node) {
//                            throw new RuntimeException();
//                        }
//                        return super.push(o);    //To change body of overridden methods use File | Settings | File Templates.
//                    }
//                });
                File file1 = new File(arg);
                String fileName = file1.getName();

                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, fileName, null, "java/lang/Object", null);
                MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC,"main" , "([Ljava/lang/String;)V", null, null);

                ast.generateBytecode(mv);
                mv.visitMaxs(0,0);
                byte[] bytecode = cw.toByteArray();
                File outputFile = new File("src/test/generated", fileName + ".class");
                FileOutputStream fstream = new FileOutputStream(outputFile);
                fstream.write(bytecode);
                fstream.close();

            }
            finally {
                file.close();
            }
        }
    }

    protected Node parse(String code, boolean abortOnError)
        throws IOException, RecognitionException
    {
        return parse(new StringReader(code), abortOnError);
    }

    protected Node parse(Reader reader, boolean abortOnError)
        throws IOException, RecognitionException
    {
        MyParser parser = new MyParser(reader);
        MyParser.program_return program = parser.program();

        if (abortOnError && parser.getError() != null) {
            throw parser.getError();
        }

        return (Node) program.getTree();
    }
}
