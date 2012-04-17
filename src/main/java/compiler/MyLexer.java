package compiler;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.RecognitionException;

public class MyLexer extends MyLexerLexer {
    private RecognitionException error;

    public MyLexer(ANTLRReaderStream stream) {
        super(stream);
    }

    public MyLexer(Reader reader)
        throws IOException
    {
        this(new ANTLRReaderStream(reader));
    }

    public void reportError(RecognitionException e) {
        super.reportError(e);
        error = e;
    }

    public RecognitionException getError() {
        return error;
    }
}
