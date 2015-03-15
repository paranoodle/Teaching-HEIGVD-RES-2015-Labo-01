package ch.heigvd.res.lab01.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;
import ch.heigvd.res.lab01.impl.*;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

  private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
  
  private int n = 0;
  private int prevChar = '\n';

  public FileNumberingFilterWriter(Writer out) {
    super(out);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
    String lines = str.substring(off, off+len);
    
    String[] current = Utils.getNextLine(lines);// = new String[]{"?", lines};
    while(!current[0].equals("")) {
        out.write(++n + "\t" + current[0]);
        current = Utils.getNextLine(current[1]);
    }
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    write(new String(cbuf), off, len);
  }

  @Override
  public void write(int c) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
    if (prevChar == '\r' && c == '\n') {
        prevChar = c;
        return;
    }
    
    if (prevChar == '\r' || prevChar == '\n') out.write(++n + "\t" + (char)c);
    else out.write(c);
    prevChar = c;
  }

}
