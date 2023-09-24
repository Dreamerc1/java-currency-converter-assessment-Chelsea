# Currency Converter User Guide

Welcome to the Currency Converter application user guide. This guide will help you understand how to use the application to convert currency efficiently.

## Table of Contents

1. [Getting Started](#getting-started)
2. [Selecting the Converter](#selecting-the-converter)
3. [Choosing Currencies](#choosing-currencies)
4. [Entering Amount](#entering-amount)
5. [Reviewing and Confirming](#reviewing-and-confirming)
6. [Completion and Results](#completion-and-results)
7. [Stretch Goals](#stretch-goals)
8. [Demo](#demo)

## Getting Started

To use the Currency Converter application, follow these steps:

1. Clone the repository to your local machine.

   ```bash
   git clone <repository-url>



2. Open the Currency COnverter project in your preferred Java IDE.



3. Sign up for your own API.

* #### In order for the API to work follow the the below instructions.
*
*  Please visit the following website to sign up for your own free API key. https://www.exchangerate-api.com/
*  Create a config.properties folder
*  Add your API key to the config.properties file
*
   >  Key=***API key goes here***
*
*  Add the config file to your **gitignore** folder.


4. Start your application by running the Main class.

## Selecting the converter

When you launch the application you will be asked to chose between two converters:

**Original Currency Converter:** This converter uses a predefined set of exchange rates relative to GBP.

**Live Rate Currency Converter:** This converter retrieves live exchange rates from an external API (stretch goal).

Enter 1 for the original converter or 2 for the live rate converter.

## Choosing Currencies

### Original Currency Converter
If you choose the original converter, you will be prompted to enter the source and destination currencies. Enter the currency codes (e.g., USD, EUR) for both source and destination currencies.

### Live Rate Currency Converter
If you select the live rate converter, follow the same steps as the original converter. However, please note that this option fetches real-time rates from an API therefore rates are subject to change without prior notice.

## Entering Amount
After choosing the currencies, the application will ask you to enter the amount you want to convert. Make sure to enter a amounts greater than 0.

## Reviewing and Confirming
The application will display a summary of your conversion request, including the source currency, destination currency, and the conversion amount. Review the details carefully.

Type 'yes' to confirm the conversion or 'no' to cancel and start over.

## Completion and Results
After confirming, the application will display the exchange rate and the converted amount. Your currency conversion is complete!

## Stretch Goals
This application explores:

* Using an API to extend the number of currencies available for the client.

* Implement the application as a command-line tool for multiple conversions (stretch goal 2).


## Demo

To see how the Currency Converter application works, check out this demo:

![Currency Converter Demo](https://res.cloudinary.com/dft0cktie/image/upload/v1695553283/bandicam_2023-09-23_21-28-28-078_xhsznk.gif)

Happy currency converting!

