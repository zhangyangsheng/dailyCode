#---
# Excerpted from "Programming Concurrency on the JVM",
# published by The Pragmatic Bookshelf.
# Copyrights apply to this code. It may not be used to create training material, 
# courses, books, articles, and the like. Contact us if you are in doubt.
# We make no guarantees that this code is fit for any purpose. 
# Visit http://www.pragmaticprogrammer.com/titles/vspcon for more book information.
#---
javac -d . TotalFileSizeSequential.java
echo ">java com.agiledeveloper.pcj.TotalFileSizeSequential /etc"
java com.agiledeveloper.pcj.TotalFileSizeSequential /etc
echo ""
echo ">java com.agiledeveloper.pcj.TotalFileSizeSequential /usr"
java com.agiledeveloper.pcj.TotalFileSizeSequential /usr
