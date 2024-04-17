Feature: To test functionality in HomeDecor
Background:
Given user is on homepage and User hover on HomeDecor
@FurnitureStore
Scenario: To validate that the stores are visible in furniture page

When  Click on furniture option
And Scroll downward 
And Select furniture type as Sofa and city as Jaipur from given dropdown list
And Click on find store
Then It should  display stores

@EnquireNow
Scenario Outline: To validate that the user is able to enquiry about Wallpaper installation

When Click on Wallpapers
And Scroll downwards
And Enter <Name> , <Email> , <Mobile no> , <Pincode>
And Click Enquiry Now
Then User is able to Enquire successfully

Examples:
|Name |Email |Mobile no |Pincode|
|Ishikaa |abcd@gmail.com | 7694099160 |451011|

@ServiceablePin
Scenario:To validate that the pincode under wallpaper is servicable

When Click on Wallpaper
And Click on Know more
And Choose Red as filter 
And Click on product
And scroll down
And Enter serviceable "<pincode>"
  |400058|
And Click on check
Then It will display THIS PIN CODE IS SERVICEABLE 


@NonServiceablePin
Scenario:To validate that the pincode under wallpaper is not servicable

When Click on Wallpaper
And Click on Know more
And Choose Red as filter 
And Click on product
And scroll down
And Enter non serviceable pincode
And Click on check
Then It will display THIS PIN CODE IS NOT SERVICEABLE 


@AddToCart
Scenario:To validate that the product is getting added to cart on clicking ADD TO CART

When Click on Wallpaper
And Click on Know more
And Choose Red as filter 
And Click on product
And scroll down
And Enter serviceable pincode
And Click on check
And Click on ADD TO CART
Then It will navigate to the Cart


