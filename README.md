# introsde-2016-assignment-1
Delivery of the first assignment of introsde 2016


## Structure of project
The project is composed of six main classes, one for each request of delivery, plus three classes for the representation of the data, all contained in the src folder. The tasks classes are stored in the *first_assignment* package, while the classes of representation of data are in the *model* package.

* __src/__
  * *first_assignment*
    * _Task1.java_ : print the list of people with all details
    * _Task2.java_ : print the healt profile of a person with the specified id
    * _Task3.java_ : print person with some condition on weight
    * _Task4.java_ : marshalling to xml of three persons
    * _Task5.java_ : unmarshelling from xml
    * _Task6.java_ : marshalling to Json of three persons
  * *model*
    * _People.java_
    * _Person.java_
    * _HealthProfile.java_
    
With the compilation of the project will be created 3 more folders in the root directory. These containing ivy, various libraries and instances of the task classes.

* __build/__
* __ivy/__
* __lib/__

In addition to folders in the root directory are several files needed for compilation and execution of the project.

* _build.xml_ : ant comands for the project 
* _ivy.xml_ : configurations of ivy
* _people.xml_ : file xml that stored persons
* _people.xsd_ : file xds for the people.xml

## Functions of project
The project's features are divided into the different classes of tasks. 

### Task 1-2-3
In the first three tasks all the code use functions relating to the xpath.
```
// The basic code for is XPath
DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
domFactory.setNamespaceAware(true);
DocumentBuilder builder = domFactory.newDocumentBuilder();
	    
Document database = builder.parse(fileXml);
		
XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();		
XPathExpression expr = xpath.compile(path);
Object result = expr.evaluate(database, XPathConstants.NODESET);
```
Where you just change the _path_ variable with the desired XPath to respond to a request.

### Task 5
This task is implemented the unmarshaller for people.xml
```
JAXBContext jc = JAXBContext.newInstance(People.class);
Unmarshaller um = jc.createUnmarshaller();

People people = (People) um.unmarshal(new FileReader("people.xml"));
List<Person> list = people.getData();
```

### Task 4-6
In these two tasks we proceed with the marshaller of Person objects to obtain in output an XML file and a JSON file. Before proceeding, however, we must instantiate the people.
```
People database = new People();
		
HealthProfile hpA = new HealthProfile(68.0, 1.78, new Date());
Person personA = new Person(new Long(1), "Andrea", "Brun", new Date(), hpA);

database.getData().add(personA);
```
And then, in task 4, we continue with the implementation of marshaller for xml.
```
JAXBContext jc = JAXBContext.newInstance(People.class);
Marshaller m = jc.createMarshaller();
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
```
And in task 6 for Json.
```
ObjectMapper mapper = new ObjectMapper();
JaxbAnnotationModule module = new JaxbAnnotationModule();

mapper.registerModule(module);
mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

String result = mapper.writeValueAsString(database);
```

## Run the project
1. Download the project from repository
  1. Extract the file if it is compressed  
2. Run a shell and go in the main directory
3. Execute it with: **ant execute.evaluation**
4. See the evaluation result
