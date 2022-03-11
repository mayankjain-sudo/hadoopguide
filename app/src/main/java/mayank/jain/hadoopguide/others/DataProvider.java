package mayank.jain.hadoopguide.others;

import mayank.jain.hadoopguide.R;

/**
 * Created by Mayank on 12/4/2016.
 */

public class DataProvider {

    public static final String[] HOME_DATA_HEADING ={"Introduction","What is BIG DATA ?","Who uses BIG DATA ?","BIG DATA Challenges"};

    public static final String[] HOME_DATA_BRIEF ={"Hello friends in this application you will learn HADOOP from scratch. This application guides you from installing java to set up HADOOP environment and running the basic program. For learning HADOOP you must have following machine configuration:\n" +
            "\t•\tUbuntu OS\n" +
            "\t•\tMin 4GB Ram, 8GB is recommended.\n" +
            "\t•\t2.2GHZ processor i3 or higher than i3, I preferred i5 processor.\n"
            ,"Big Data means collection of so large and complex dataset that cannot be processed by using traditional method. Or we can describe as a huge volume of data which include both structure and unstructured data that cannot be processed using old technique."
            ,"\t•\tBanking Sector: Maintaining daily transaction record etc.\n" +
            "\t•\tHealth Care: Maintaining Patient records, prescription information etc.\n" +
            "\t•\tGovernment: Maintaining Adhar Card details etc.\n" +
            "And much more sector are using BIG DATA now a days.\n" +
            "To handle such BIG DATA new technologies are coming in which HADOOP is one of the technology which we are going to learn this application.\n"
            ,"\t•\tSearching\n" +
            "\t•\tCapturing Data\n" +
            "\t•\tStorage\n" +
            "\t•\tAnalysis\n" +
            "\t•\tPresentation\n" +
            "\t•\tSharing Data\n" +
            "\t•\tTransferring Data\n"
            ,"m5","m6","m7","m8","m9","m10"};


    public static final String[] INTRO_DATA_HEADING ={"What is Hadoop ?","Why is Hadoop important?","What are the challenges of using Hadoop?"};

    public static final String[] INTRO_DATA_BRIEF ={"Hadoop is an open source Java based programming framework that supports the storage and processing of very huge data in distributing computing environment.It is designed to scale up from single server to thousands of machine where each machine is offering local computational and storage.Hadoop is a part of Apache project sponsored by the Apache Software Foundation."
            ,"\t•\tAbility to store and process huge volume of any kind of data very quickly.\n" +
            "\t•\tComputing power\n" +
            "\t•\tFault tolerance\n" +
            "\t•\tFlexibility\n" +
            "\t•\tLow cost\n" +
            "\t•\tScalability\n"
            ,"\t•\tMap-Reduce programming is not a good match for all problems.\n" +
            "\t•\tData security. \n" +
            "\t•\tFull-fledged data management and governance.\n"
            ,"m4","m5","m6","m7","m8","m9","m10"};

    public static final String[] MACHINE_DATA_HEADING ={"Setting root user password"
            ,"Enabling root user for graphical Interface"
            ,"Enabling root user for graphical Interface Continue…"
            ,"After restarting machine"};

    public static final String[] MACHINE_DATA_BRIEF ={"For enabling root user first we set the password of the root. For this run the below command:\n" +
            "\t•\tsudo passwd\n" +
            "After running the above command it will prompt to enter new unix password.Enter the password what you want to set for root user and then press enter it will again prompt for retype the password then retype the password and press enter you will see the message that password updated successfully.\n"
            ,"To enable the root user for graphical user interface follow the below step:\n" +
            "\t•\tOpen new terminal \n" +
            "\t•\tRun the command\n" +
            "\t•\tsudo -i\n" +
            "\t•\tThe above command enter you in root user \n" +
            "\t•\tNow run the command\n" +
            "\t•\tlocate lightdm.conf\n" +
            "Now we have to edit the file 50-unity-greeter.conf file for that run the below command:\n" +
            "\t•\tgedit /usr/share/lightdm/lightdm.conf.d/50-unity-greeter.conf\n"
            ,"After running the above command i.e. , for editing the 50-unity-greeter.conf file come to the last line of the file and type the below line :\n" +
            "\t•\tgreeter-show-manual-login=true\n"+
            "Now save the file close it and restart your machine.\n"
            ,"After restarting your machine you will see that root user graphical user interface is enable.\n" +
            "Now pressing down arrow key go to the Login option and then enter your username as root and press enter then enter your password and press enter. Now you are login as a root user in your machine.\n"
            ,"m5","m6","m7","m8","m9","m10"};

    public static final int [] MACHINE_DATA_IMAGE = {R.drawable.mcdatacapture1, R.drawable.mcdatacapture2
            ,R.drawable.mcdatacapture3,R.drawable.mcdatacapture4};

    public static final String[] JAVA_DATA_HEADING = {"Downloading JAVA","Moving JAVA","Setting Environment Variable","Editing in File",
            "After restarting Machine "};

    public static final String[] JAVA_DATA_BRIEF={"First go to the oracle site and download the JDK according to your machine that is x64  or x32\n" +
            "I had already download it and it is present in my download directory.\n" +
            "Now open the terminal and go the directory where you downloaded the JDK, now untar your JDK file.\n" +
            "Now using terminal create a directory java in root\n" +
            "\t•\tmkdir java\nNow move the extracted JDK folder in the newly created java directory.\n"
            ,"Go to the directory where extracted java is placed and then use the below command to move it in newly created java directory.\n" +
            "\t•\tmv jdk1.8.0_45 /java\nTo confirm it go to newly created java directory in root and see that jdk folder is present in the java directory.\n"
            ,"For setting java environment variable for all user of UBUNTU we edit in the file by below command:\n" +
            "\t•\tgedit /etc/profile\n"
            ,"It will open a file now go to the last line of the file and enter the lines given below:\n" +
            "#Setting JAVA Variables\n" +
            "\t\texport JAVA_HOME=/java/jdk1.8.0_45\n" +
            "\t\texport PATH=$PATH:.:$JAVA_HOME/bin\nNow after editing save the file and close it and restart your machine.\n\n"
            ,"After restarting your machine open the terminal and run the below command:\n" +
            "\t•\tjava –version\n" +
            "It display the java version which we installed in above steps. \n\n"};
    public static final int [] JAVA_DATA_IMAGE ={R.drawable.javaconfcapture1
            ,R.drawable.javaconfcapture2,R.drawable.javaconfcapture3,R.drawable.javaconfcapture4,R.drawable.javaconfcapture5};


    public static final String[] HADOOP_DATA_HEADING = {"Installing SSH","Create and Setup SSH certificate"
            ,"Testing SSH","HADOOP SETUP","Setup Hadoop Configuration Files","Setting hadoop-env.sh FILE"
            ,"Creating the app directory in root","Editing in core-site.xml","Editing in mapred-site.xml"
            ," Editing in hdfs-site.xml","Formatting the new Hadoop File System","Starting Hadoop"};

    public static final String[] HADOOP_DATA_BRIEF = {"Before installing HADOOP we need to update the system first. For this run the below command :\n" +
            "\t•\tapt-get update (since we are login as root user so there is no need to use sudo)\n" +
            "\t•\tssh : The command we use to connect to remote machines - the client. \n" +
            "\t•\tsshd : The daemon that is running on the server and allows clients to connect to the server. \n" +
            "The ssh is pre-enabled on Linux, but in order to start sshd daemon, we need to install ssh first. Use the below command to do that :\n" +
            "\t•\tapt-get install ssh\n"
            ,"Hadoop requires SSH access to manage its nodes, i.e. remote machines plus our local machine. For our single-node setup of Hadoop, we therefore need to configure SSH access to localhost.\n" +
            "So, we need to have SSH up and running on our machine and configured it to allow SSH public key authentication.\n" +
            "Hadoop uses SSH (to access its nodes) which would normally require the user to enter a password. However, this requirement can be eliminated by creating and setting up SSH certificates using the following commands. If asked for a filename just leave it blank and press the enter key to continue. Use  below command to set up:\n" +
            "\t•\tssh-keygen –t  rsa –P “”\n After running the above command run the below command for adds the newly created key to the list of authorized keys so that Hadoop can use ssh without prompting for a password.\n" +
            "\t•\tCat $HOME/.ssh/id_rsa.pub >> $HOME/.ssh/authorized_key\n"
            ,"After running all above command now it’s time to test the SSH for this run the below command:\n" +
            "\t•\tssh localhost\n" +
            "You will see the below output, it means ssh is configure successfully.\n"
            ,"Download the HADOOP from below link\n" +
            "\t•\thttp://apache.mirror.iweb.ca/hadoop/common/hadoop-2.7.3/hadoop-2.7.3.tar.gz\n" +
            "Extract the tar file using commad \n" +
            "\t•\ttar –xvf hadoop-2.7.3.tar.gz\n" +
            "Now create a Hadoop directory in /usr/local/ and move the extracted Hadoop folder in that directory for this run the below command:\n" +
            "\t•\tmkdir /usr/local/hadoop\n" +
            "Since my extracted Hadoop is present in  Download directory so I am moving it from that location.\n" +
            "\t•\tmv /root/Downloads/hadoop-2.7.3 /usr/local/hadoop/\n" +
            "Now we give the permission and owernship to the hadoop folder for this run the below command\n" +
            "\t•\tchown –R root:root /usr/local/hadoop\n" +
            "\t•\tchmod 777 /usr/local/hadoop\n"
            ,"To set up hadoop we need to edit in the following files which is present in hadoop folder.\n" +
            "\t•\t/usr/local/hadoop/etc/hadoop/hadoop-env.sh\n" +
            "\t•\t/usr/local/hadoop/etc/hadoop/core-site.xml\n" +
            "\t•\t/usr/local/hadoop/etc/hadoop/mapred-site.xml\n" +
            "\t•\t/usr/local/hadoop/etc/hadoop/hdfs-site.xml\n" +
            "Since we already added the java path in /etc/profile file now we have to add the Hadoop path in /etc/profile for this run the below command:\n" +
            "\t•\tgedit /etc/profile\n" +
            "\t•\tThe above command open a file now come to end of the file where you set java variables before after that edit the following lines:\n" +
            "\t•\t#HADOOP VARIABLE START\n" +
            "\t•\texport HADOOP_INSTALL=/usr/local/hadoop\n" +
            "\t•\texport PATH=$PATH:$HADOOP_INSTALL/bin\n" +
            "\t•\texport PATH=$PATH:$HADOOP_INSTALL/sbin\n" +
            "\t•\texport HADOOP_MAPRED_HOME=$HADOOP_INSTALL\n" +
            "\t•\texport HADOOP_COMMON_HOME=$HADOOP_INSTALL\n" +
            "\t•\texport HADOOP_HDFS_HOME=$HADOOP_INSTALL\n" +
            "\t•\texport YARN_HOME=$HADOOP_INSTALL\n" +
            "\t•\texport HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_INSTALL/lib/native\n" +
            "\t•\texport HADOOP_OPTS=\"-Djava.library.path=$HADOOP_INSTALL/lib\"\n" +
            "\t•\t#HADOOP VARIABLES END\n Now save the file and close it."
            ,"We need to set JAVA_HOME in hadoop-env.sh file. By adding the JAVA_HOME in the file it ensure that java is available to HADOOP whenever HADOOP is started. For this run the following command :\n" +
            "\t•\tgedit /usr/local/hadoop/etc/hadoop/hadoop-env.sh\n" +
            "\t•\tThe above command open the file now add the java variable in see the following image.\n" +
            "\t•\tAfter adding the java variable save the file and close it.\n"
            ,"Now we will create a app directory in root inside app directory we create a hadoop directory and inside the hadoop directory we create a tmp directory. I will tell you the use of above directory later. For creating the above directory structure run the following command:\n" +
            "\t•\tmkdir –p /app/hadoop/tmp\n" +
            "\t•\tAfter creating the above directory structure give the privileges to the directory for this run the below command:\n" +
            "\t•\tchown –R root:root /app/hadoop/tmp \n"
            ," Now open the core-site.xml file and add the following lines in between the <configuration></ configuration > for this run the below command:\n" +
            "\t•\tgedit /usr/local/hadoop/etc/hadoop/core-site.xml\n" +
            "\t•\tThe above command open a file now add the below lines : \n" +
            "                  <property>\n" +
            "  \t\t<name>hadoop.tmp.dir</name>\n" +
            "  \t\t<value>/app/hadoop/tmp</value>\n" +
            "  \t\t<description>A base for other temporary directories.</description>\n" +
            " \t     </property>\n" +
            "\n" +
            " \t    <property>\n" +
            "  <name>fs.default.name</name>\n" +
            "  \t\t  <value>hdfs://localhost:54310</value>\n" +
            "  \t\t <description>The name of the default file system.  A URI whose\n" +
            "  \t\t    scheme and authority determine the FileSystem implementation.  The\n" +
            "  \t\t    uri's scheme determines the config property (fs.SCHEME.impl) naming\n" +
            "  \t\t    the FileSystem implementation class.  The uri's authority is used to\n" +
            "  \t\t    determine the host, port, etc. for a filesystem.</description>\n" +
            " \t    </property>\n" +
            "Now save the file and close it.\n"
            ,"The mapred-site.xml file is used to specify which framework is used for Map Reduce. Since mapred-site.xml is not available by default so we have to create it in the directory. By default mapred-site.xml.template is available so we copy it and rename it in the same directory for this run the following command:\n" +
            "\t•\tcp /usr/local/hadoop/etc/hadoop/mapred-site.xml.template /usr/local/hadoop/etc/hadoop/mapred-site.xml\n" +
            "\t•\tThe above command create a file name with name mapred-site.xml\n" +
            "\t•\tNow open the mapred-site.xml file and add the following lines in between <configuration></configuration> tag\n" +
            "<property>\n" +
            "      <name>mapred.job.tracker</name>\n" +
            "      <value>localhost:54311</value>\n" +
            "      <description>The host and port that the MapReduce job tracker runs\n" +
            "               at.If \"local\", then jobs are run in-process as a single map\n" +
            "               and reduce task.\n" +
            "     </description>\n" +
            " </property>\n" +
            "\n" +
            "Save the file and close it.\n"
            ,"This file needs to be configured for each host in the cluster thata is begin used. It is used to specify the directories which will be used as the namenode and datanode  on that host. Before editing this file we need to create two directories which will contain the namenode and the datanode for this Hadoop installation. Run the following command to do so:\n" +
            "\t•\tmkdir –p /usr/local/hadoop_store/hdfs/namenode\n" +
            "\t•\tmkdir –p /usr/local/hadoop_store/hdfs/datanode\n" +
            "\t•\tchown –R root:root /usr/loca/hadoop_store\n" +
            "Now open the file hdfs-site.xml and add the below content between <configuration></ configuration > tag. For doing such run the below command it will open the file for editing:\n" +
            "\t•\tgedit /usr/local/hadoop/etc/hadoop/hdfs-site.xml\n" +
            "\t•\tAfter opening the file add the below lines of code save it and close it.\n" +
            "       \n" +
            " <property>\n" +
            " \t<name>dfs.replication</name>\n" +
            " \t\t \t<value>1</value>\n" +
            " \t\t \t<description>Default block replication.\n" +
            "The actual number of replications can be specified when the file is created.The default is used if replication is not specified in create time.\n" +
            "  \t\t\t</description>\n" +
            " \t\t</property>\n" +
            " \t\t<property>\n" +
            "   \t\t\t<name>dfs.namenode.name.dir</name>\n" +
            "   \t\t\t<value>file:/usr/local/hadoop_store/hdfs/namenode</value>\n" +
            "</property>\n" +
            " \t\t<property>\n" +
            " \t\t\t <name>dfs.datanode.data.dir</name>\n" +
            "   \t\t\t <value>file:/usr/local/hadoop_store/hdfs/datanode</value>\n" +
            " \t\t</property>\n Save the file and close it. \n"
            ,"Now, the Hadoop file system needs to be formatted so that we can start to use it. The format command should be issued with write permission since it creates current directory under /usr/local/hadoop_store/hdfs/namenode folder. Run the below command to do so:\n" +
            "\t•\thadoop namenode –format\n" +
            "\t•\tAfter running the above command successfully it show output seen in below image.   \n" +
            "Note: That hadoop namenode -format command should be executed once before we start using Hadoop.If this command is executed again after Hadoop has been used, it'll destroy all the data on the Hadoop file system.\n"
            ,"Now it's time to start the newly installed single node cluster. \n" +
            "We can use start-all.sh or (start-dfs.sh and start-yarn.sh)\n" +
            "\t•\tFirst give permission to hadoop directory by running the below command:\n" +
            "\t•\tchmod 777 –R /usr/local/hadoop/*\n" +
            "\t•\tNow run the hadoop by running below command:\n" +
            "\t•\t/usr/local/hadoop/sbin/start-all.sh\n" +
            "\t•\tOr you can run simply run the below command to start hadoop:\n" +
            "\t•\tstart-all.sh\n" +
            "\t•\tAfter running the above command to check hadoop is running or not run the below commad :\n" +
            "\t•\tjps\n" +
            "\t•\tThe above command give the below out as show in image(Note: The numerical value may differ).\n"};

    public static final int [] HADOOP_DATA_IMAGE = {R.drawable.hadoopconfcapture1,R.drawable.hadoopconfcapture2
            ,R.drawable.hadoopconfcapture3,R.drawable.hadoopconfcapture4,R.drawable.hadoopconfcapture5
            ,R.drawable.hadoopconfcapture6,R.drawable.hadoopconfcapture7,R.drawable.hadoopconfcapture8
            ,R.drawable.hadoopconfcapture9,R.drawable.hadoopconfcapture10,R.drawable.hadoopconfcapture11,R.drawable.hadoopconfcapture12};

    public static final String ABOUT_US ="We are a team of young and energetic developers, ready to explore in any technology domain," +
            "we have expertise in Android,JAVA,Nodejs,Python,Angularjs,ERP etc. We work as product development and solution expert and " +
            "also involved in new technology.You can reach us for any technical solution.\n" +
            "Email Us on : jaine.mayank@gmail.com";

}
