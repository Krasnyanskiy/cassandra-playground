### Playground for ![alt text](http://www.cdata.com/ui/img/icon-cassandra.png "Hoho")
-----
##### How to install Cassandra cluster locally

1. Install [ccm](https://github.com/pcmanus/ccm) via 

   ```bash
   $> brew install ccm
   ```

2. Add ip aliases using `ifconfig`

   ```bash
   $> sudo ifconfig lo0 alias 127.0.0.2
   $> sudo ifconfig lo0 alias 127.0.0.3
   ...
   ```
   
3. Fetch Cassandra via ccm, start the cluster and check its status

   ```bash
   $> ccm create -v 2.1.5 -n 5 kabzon
   $> ccm start
   $> ccm status
   ```
   
   It should print something like this
   ```bash
   Cluster: 'kabzon'
   -----------------
   node1: UP
   node3: UP
   node2: UP
   node5: UP
   node4: UP
   ```

4. Fill the cluster with data

   ```bash
   $> ccm node1 cqlsh SOURCE '~/path/to/file/changes_01.cql';
   ```

5. Check the last operation result

   ```bash
   cqlsh> SELECT * FROM users;
   ```
   
6. If the result isn't empty, then your cluster is ready to use.
