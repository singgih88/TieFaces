[![Maven](https://maven-badges.herokuapp.com/maven-central/org.tiefaces/tiefaces/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.tiefaces/tiefaces)
[![Travis](https://travis-ci.org/tiefaces/TieFaces.svg?branch=master)](https://travis-ci.org/tiefaces/TieFaces)
[![Coverage Status](https://coveralls.io/repos/github/tiefaces/TieFaces/badge.svg)](https://coveralls.io/github/tiefaces/TieFaces)
[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT)

# Tiefaces Web Sheet

> Tiefaces Web Sheet is a JSF UI component (built upon Primefaces) which can render excel templates as Web form. It also use special mark-up in the template to support data input/output. 

This is an overview page, please visit [TieFaces.org](http://tiefaces.org) for more information.

## Features
### Render excel templates as web forms
  - Support multiple sheets
  - Keep Excel formats and styles
  - Keep Excel formulas
  - Support charts and images
![Render excel as web form](http://showcase-tiefaces.rhcloud.com/javax.faces.resource/img/websheet1.png.xhtml?ln=showcase)

### Dynamic Web Form Solution
- Use expression language to define data.
- Use special command in the cell comment to define features.
- Two way binding between data and cell object.
- Support multiple input/output widget. i.e. calendar, dropdown, inputNumber, inputArea etc.
- Support nested data collections. i.e. a company include multiple departments while each department include multiple employees.
- Support add/delete functions for data collections.

![Dynamic web solution](http://showcase-tiefaces.rhcloud.com/javax.faces.resource/img/websheet2.png.xhtml?ln=showcase)

### Getting Started
***

**TieFaces** can be download manually or via maven.  

##### Latest Downloads
Version | Binary | Source | Java Doc 
------------ | -------------  | ------------- | -------------  
1.0.5 | [tiefaces-1.0.5.jar](http://central.maven.org/maven2/org/tiefaces/tiefaces/1.0.3/tiefaces-1.0.5.jar) | [tiefaces-1.0.5-sources.jar](http://central.maven.org/maven2/org/tiefaces/tiefaces/1.0.5/tiefaces-1.0.5-sources.jar) | [tiefaces-1.0.5-javadoc.jar](http://central.maven.org/maven2/org/tiefaces/tiefaces/1.0.5/tiefaces-1.0.5-javadoc.jar)

You can also visit download page in [tiefaces.org](http://www.tiefaces.org/).

##### Maven

```xml
<dependency>  
    <groupId>org.tiefaces</groupId>  
    <artifactId>tiefaces</artifactId>  
    <version>1.0.5</version>  
</dependency>  
```

### Usage
***

##### Namespaces

Use namespace below to add TieFaces components to your pages.

```xml
xmlns:tie="http://tiefaces.org/tiefaces"
```

### Demo
***
Please refer to the demo page of [tiefaces.org](http://tiefaces.org/) in order to see the full usage of the components. 

### License
***
Code released under the [MIT License](LICENSE).
