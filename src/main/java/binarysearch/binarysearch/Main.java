package binarysearch.binarysearch;

import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
	 
	public static int binarySearch( Comparable [ ] a, Comparable x )
  {
      int first = 0;
      int last = a.length - 1;
      int mid;

      while( first <= last )
      {
          mid = ( first + last ) / 2;

          if( a[ mid ].compareTo( x ) < 0 )
              first = mid + 1;
          else if( a[ mid ].compareTo( x ) > 0 )
              last = mid - 1;
          else
              return mid;
      }

      return -1;     // NOT_FOUND = -1
  }


public static void main(String[] args) throws Exception {
	
   
Options options = new Options();

Option type = Option.builder("Type")
.required()
.longOpt("type")
.desc("specifies the type of input: 'i' for integer and 's' for string")
.hasArg()
.argName("TYPE")
.build();
options.addOption( type );

Option key = Option.builder("Key")
.required()
.longOpt("key")
.desc("specifies the element to be searched in the list")
.hasArg()
.argName("KEY")
.build();
options.addOption( key );


Option list = Option.builder("List")
.required()
.longOpt("list")
.desc("specifies the list of sorted integer or strings")
.hasArgs()
.argName("LIST")
.build();
options.addOption( list );




CommandLineParser commandLineParser = new DefaultParser();

CommandLine commandLine;
try{
commandLine = commandLineParser.parse(options, args);

String typeelement = commandLine.getOptionValue("type");
String keyelement = commandLine.getOptionValue("key");
String [] listelements = commandLine.getOptionValues("list");





int c;
if(typeelement.compareTo("s")==0){
	c=binarySearch(listelements,keyelement);
	if(c==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
}else if(typeelement.compareTo("i")==0){
	 c=binarySearch(listelements,keyelement);
	if(c==-1)
	  System.out.println("0");
	else
	System.out.println("1")	;
}
}
catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	}




}

}
