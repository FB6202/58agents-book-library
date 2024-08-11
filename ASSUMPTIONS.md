# Additional Assumptions 

## assumptions overview
- unique book title
- unique user email address
- every loan should have at least one book
- books have another attribute (available), that is updated every time a loan comes in
- almost the complete validation and functionality is performed in the backend
- you cannot edit the book selection of a single loan, only the metadata (loan data, return date and member)

## additional explanations
-> considering that the data transfer objects coming from the client minimize error possibilities
-> validation would be performed on both sides!
-> in order to update books of a loan you can delete the old loan and add a new one (easier for the frontend)

## info
-> actually you can build the docker image via spring-boot-plugin from gradle (bootBuildImage task)
