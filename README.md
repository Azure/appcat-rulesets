# Project

> This repo has been populated by an initial template to help get you started. Please
> make sure to update the content to build a great experience for community-building.

As the maintainer of this project, please make a few updates:

- Improving this README.MD file to provide a great experience
- Updating SUPPORT.MD with content about this project's support experience
- Understanding the security reporting process in SECURITY.MD
- Remove this section from the README

## Contributing

This project welcomes contributions and suggestions.  Most contributions require you to agree to a
Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us
the rights to use your contribution. For details, visit https://cla.opensource.microsoft.com.

When you submit a pull request, a CLA bot will automatically determine whether you need to provide
a CLA and decorate the PR appropriately (e.g., status check, comment). Simply follow the instructions
provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or
contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Trademarks

This project may contain trademarks or logos for projects, products, or services. Authorized use of Microsoft 
trademarks or logos is subject to and must follow 
[Microsoft's Trademark & Brand Guidelines](https://www.microsoft.com/en-us/legal/intellectualproperty/trademarks/usage/general).
Use of Microsoft trademarks or logos in modified versions of this project must not cause confusion or imply Microsoft sponsorship.
Any use of third-party trademarks or logos are subject to those third-party's policies.

Windup Rulesets
===============

Rules and rulesets contributed by community.

Follow the [Get Involved](https://github.com/windup/windup/wiki/Get-Involved) in Windup wiki.


Directory structure
-----------

The `rules` module repository is organized in subdirectories:

* `rules-reviewed`: this is where you can make contribution and add new rules
* `rules-generated`: these rules are automatically generated (from the Quarkus main git repo) and you should not add new rules here
* `rules-overridden-azure`: this is where you can override existing rules (mostly the ones under `rules-reviewed`)

Testing the rules
-----------

To limit the XML-based tests (`windup.test.xml`) which are run, use `-DrunTestsMatching=...`.
The value can be any part of the test filename to match. Like, `-DrunTestsMatching=hsearch`.

By default, when executing the tests, the `href` attributes of the `<link>` tags are also tested. This means that there is an external request to each URL. 
If you want to avoid this, you can use the `-Dtest=WindupRulesTest` flag in conjunction with the `-f` flag:

```
mvn clean test -f rules -Dtest=WindupRulesTest -DrunTestsMatching=hsearch
```

Building from source
-----------

Ensure you use the provided Maven Wrapper utility to build the project, as Windup requires Maven 3.8.8:

        ./mvnw verify
