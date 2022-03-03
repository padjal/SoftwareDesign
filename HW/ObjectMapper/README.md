# Object Mapper
##💡 About
### Intro
Object Mapper is a java library for object serialization in Yaml format. It allows mapping java objects to and from Strings, InputStreams and files.

###👨🏼‍🚀 About me
This project is realized as part of my 2nd year course "Software Design" of my bachelor studies in HSE, Moscow. 

Student: Dzhalev Pavel Dobrev<br>
Group: БПИ208<br>
Course: Software Design, year 2<br>
University: HSE, Moscow

##🧾 Yaml
As per their own [website](https://yaml.org), <i> YAML is a human-friendly data serialization
language for all programming languages.</i> It is very light and easy to read and modify by a human and that is why it is often the format of choice for saving application configurations and settings.

### Format
Yaml is inherited from JSON and thus also implements some of its is core functionalities like <b>a key-value pair</b>, various data formats, and collections. In order to denote nesting, yaml uses indentation and therefore does not need braces like JSON.

A simple example of the yaml format:
```
--- !<tag:clarkevans.com,2002:invoice>
invoice: 34843
date   : 2001-01-23
bill-to: &id001
    given  : Chris
    family : Dumars
    address:
        lines: |
            458 Walkman Dr.
            Suite #292
        city    : Royal Oak
        state   : MI
        postal  : 48046
ship-to: *id001
product:
    - sku         : BL394D
      quantity    : 4
      description : Basketball
      price       : 450.00
    - sku         : BL4438H
      quantity    : 1
      description : Super Hoop
      price       : 2392.00
tax  : 251.42
total: 4443.52
comments:
    Late afternoon is best.
    Backup contact is Nancy
    Billsmer @ 338-4338.
```