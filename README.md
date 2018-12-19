# car-insurance

# DB Structure

```
TABLE `customer` (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `province` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `insurance_id` varchar(10) NOT NULL,
  `expire_date` date NOT NULL
)

TABLE `insurance` (
  `insurance_id` int(20) NOT NULL,
  `insurance_name` varchar(100) NOT NULL,
  `insurance_type` varchar(10) NOT NULL,
  `box1` varchar(200) DEFAULT NULL,
  `box2` varchar(200) DEFAULT NULL,
  `box3` varchar(200) DEFAULT NULL,
  `box4` varchar(200) DEFAULT NULL,
  `remark` varchar(4000) DEFAULT NULL
)

TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name_lastname` varchar(100) NOT NULL
)
```
