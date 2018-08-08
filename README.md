# willowtreetest
Here are the items that have been done:

Consume API data - Done
Return back 6 random users - Done with one selected
Statistics - done
Matt mode ++: made it so that multiple names can be returned : 'Jo' 'Matt'


Since I decided to do this in Springboot, I did a lot of the testing in the brower and didn't create the unit tests. 

Test Urls:
start game and get random people : http://localhost:8080/start

guess wrong: http://localhost:8080/guess?name=Matt&guessId=3UanW3Rdq08YuyeocUcU8K

guess right: http://localhost:8080/guess?name=Jordan&guessId=3UanW3Rdq08YuyeocUcU8K

guess right partial: http://localhost:8080/guess?name=Jo&guessId=3UanW3Rdq08YuyeocUcU8K

searchBy name start: http://localhost:8080/searchByFirstName?name=Jo

search by name not thereL http://localhost:8080/searchByFirstName?name=Joan

search by There: http://localhost:8080/searchByFirstName?name=matt

get All: http://localhost:8080/list

stats: http://localhost:8080/stats
