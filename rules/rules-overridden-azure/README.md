Azure Rules overriding Windup Rules
===============

In this `rules-overridden-azure` directory, you will find the Azure rules that are overriding the Windup rules (mostly the ones under `rules-reviewed`).

Directory structure
-----------

The `rules-overridden-azure` directory mimics the `rules-reviewed` directory structure.
This means that you will find the same subdirectories (`azure`, `camel`, `droolsjbpm`...) and the same files when a rule needs to be overriden.

Overriding an existing rule
-----------

Rules written in XML or Groovy can be overridden either in XML or Groovy.
It doesn't matter if the original rule is written in XML or Groovy, you can override it in either language.

[To override an existing rule](https://windup.github.io/windup-documentation/website/docs/rules-development-guide/master.html#overriding-rules_rules-development-guide), the ruleset must have the same ruleset id and the same id attribute as the original rule.
It may have the same filename, but that is not a requirement.

For example, let's say you want to override the `rules-reviewed/technology-usage/database.windup.groovy` rule:


```groovy
.addRule()
.when(File.inFileNamed("{*}postgresql{*}.jar"))
.perform(new AbstractIterationOperation<FileLocationModel>() {
    void perform(GraphRewrite event, EvaluationContext context, FileLocationModel payload) {
        perform(event, context, payload.getFile(), "PostgreSQL Driver", true)
    }
})
.withId("database-01700")
```

You create the `rules-overridden-azure/technology-usage/database.windup.xml` XML file (or Groovy if you prefer) with the following content:

```xml
<ruleset id="database">
    <metadata>
        <targetTechnology id="azure-spring-apps"/>
        <targetTechnology id="azure-appservice"/>
        <targetTechnology id="azure-aks"/>
        <targetTechnology id="azure-container-apps"/>
        <overrideRules>true</overrideRules>
    </metadata>
    <rules>
        <rule id="database-01700">
            <when>
                <file filename="{*}postgresql{*}.jar"/>
            </when>
            <perform>
                <hint title="PostgreSQL database found" category-id="potential" effort="3">
                    <message>
                        Consider using Azure PostgreSQL Flexible Server.
                    </message>
                </hint>
            </perform>
        </rule>
    </rules>
</ruleset>
```

Notice that the `<ruleset id="database">` is the same as the original rule, and the `<rule id="database-01700">` is the same as the original rule id.
You also need to add `<overrideRules>true</overrideRules>`

Testing an overriden rule
-----------

Then, to test the overriden rule, you can create two separate tests:
one testing that the original rule still works when the target is the original one (here `<target>discovery</target>`):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ruletest id="database-test">
    <testDataPath>../../../rules-reviewed/technology-usage/tests/data/database</testDataPath>
    <rulePath>../../../rules-reviewed/technology-usage/database.windup.groovy</rulePath>
    <rulePath>../database.windup.xml</rulePath>
    <target>discovery</target>
    <ruleset>
        <!-- ... -->
    </ruleset>
</ruletest>
```

and one test for testing the overriden rule with its specific target (`<target>azure-appservice</target>`):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ruletest id="database-test">
    <testDataPath>../../../rules-reviewed/technology-usage/tests/data/database</testDataPath>
    <rulePath>../../../rules-reviewed/technology-usage/database.windup.groovy</rulePath>
    <rulePath>../database.windup.xml</rulePath>
    <target>azure-appservice</target>
    <ruleset>
        <!-- ... -->
    </ruleset>
</ruletest>
```

To test a WindUp rule you need to have some data.
For overidden rules, you can use the same data as the original rule.
For that, you can point `<testDataPath>` to the original directory (`<testDataPath>../../../rules-reviewed/technology-usage/tests/data/database</testDataPath>`).

Then, test your rule by executing a `mvn test`.
To limit the XML-based tests (`windup.test.xml`) which are run, use `-DrunTestsMatching=...`. 
The value can be any part of the test filename to match.
Like, `-DrunTestsMatching=database`.
