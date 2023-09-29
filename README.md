# [DEMOQA.COM](https://demoqa.com) SELENIUM WEBDRIVER TESTS

[![Feature Branch](https://github.com/dj-luis198/selenium_java_maven_testng/actions/workflows/main.yml/badge.svg)](https://github.com/dj-luis198/selenium_java_maven_testng/actions/workflows/main.yml)

Link a reporte de pruebas  https://dj-luis198.github.io/selenium_java_maven_testng/

----------------------------

[DemoQA](https://demoqa.com) es una página provista por toolsqa.com para realizar practicas con Selenium. La misma posee módulos como botones, menús, formularios, etc.

En estas pruebas automatizadas se utilizó Selenium WebDriver con Java aplicando el patron de diseño POM (Page Object Model).

Las pruebas se realizan en los browsers Chrome, Firefox y Edge; dando un total de 325 test.

Se utilizan distintos métodos para proveer datos a las pruebas, por medio de JsonSimple, Faker data y Data Provider con Excel.

Las pruebas API se realizan con Rest Assured, validando tanto datos como schemas.

El reporte de pruebas se realiza con Extent reports.

Las pruebas se corren en paralelo y en caso de fallar una o más de ellas se correran hasta 2 veces más cada una para así descartar falsos negativos.

En su mayoría las assercions son hard-Assercions, pero en modo de práctica se introducen soft-Assercions.


## Pre requisitos
Se requiere tener descargado java, Apache Maven y configurada la variable de entorno tanto de java como de Maven.
> Versiones `20.0.2` , `3.9.3` de java y apache maven, respectivamente. Le sugiero que use la misma versión o versiones posteriores.

## Pruebas
Ejecutar `mvn clean test` en la terminal de su editor de codigo favorito para correr todas las pruebas en paralelo.

## Test

Alerts, Frame and Windows

[Alerts](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/AlertsFrameWindows/AlertsTest.java)

[Browser and Windows](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/AlertsFrameWindows/BrowserWindowsTest.java)

[Frames](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/AlertsFrameWindows/FramesTest.java)

[Modal Dialogs](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/AlertsFrameWindows/ModalDialogsTest.java)

[Nested Frames](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/AlertsFrameWindows/NestedFramesTest.java)

Elements

[Broken Links Images](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/BrokenLinksImagesTest.java)

[Buttons](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/ButtonsTest.java)

[CheckBox](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/CheckBoxTest.java)

[Dynamic Properties](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/DynamicPropertiesTest.java)

[Links](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/LinksTest.java)

[Radio Button](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/RadioButtonTest.java)

[TextBox](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/TextBoxTest.java)

[Upload And Download](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/UploadAndDownloadTest.java)

[WebTables](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/elements/WebTablesTest.java)

Form

[Form](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/forms/FormTest.java)

Widgets

[Accordian](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/AccordianTest.java)

[Auto Complete](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/AutoCompleteTest.java)

[DatePicker](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/DatePickerTest.java)

[Menu](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/MenuTest.java)

[ProgressBar](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/ProgressBarTest.java)

[Select Menu](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/SelectMenuTest.java)

[Slider](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/SliderTest.java)

[Tabs](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/TabsTest.java)

[ToolTips](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/widgets/ToolTipsTest.java)

Book Store

[Book Store](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/bookStore/BookStoreTest.java)

APIs (Rest Assured)

[Post User](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/usertests/PostUser.java)

[Post Token](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/usertests/PostToken.java)

[Post Authorized](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/usertests/PostAuthorized.java)

[Get User](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/usertests/GetUser.java)

[Delete User](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/usertests/DeleteUser.java)

[Delete Book](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/DeleteBook.java)

[Delete Books](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/DeleteBooks.java)

[Get Book](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/GetBook.java)

[Get Books](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/GetBooks.java)

[Post Books User](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/PostBooksUser.java)

[PutBook](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/api/test/booktest/PutBook.java)

Hybrid GUI API test

[Login cookies](https://github.com/dj-luis198/selenium_java_maven_testng/blob/main/src/test/java/com/demoqa/test/bookStoreHybridGuiApi/BookStoreCookies1.java)






