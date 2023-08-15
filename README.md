# redisson-performance-webFlux

To Measure performance, I have downloaded jmeter and created a folder inside bin and configured .jmx file.

.jmx file configuration below:

Number of threads : 180

Ramp up period: 30 sec

Duration: 300 sec

performance test without redis:

./jmeter -n -t redis-course/product-service.jmx -l redis-course/v1.jtl

![image](https://github.com/moniir/redisson-performance-webFlux/assets/15854799/5648777a-940d-4b00-8e03-09667af8ef3e)


performance test with redis:

./jmeter -n -t redis-course/product-service.jmx -l redis-course/v2.jtl

![image](https://github.com/moniir/redisson-performance-webFlux/assets/15854799/a4c3e624-b649-4493-86f6-7501208940ea)
