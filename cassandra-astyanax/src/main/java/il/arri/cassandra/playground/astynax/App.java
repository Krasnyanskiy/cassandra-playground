package il.arri.cassandra.playground.astynax;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolType;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;

import static com.netflix.astyanax.thrift.ThriftFamilyFactory.getInstance;
import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

/**
 * @author Alexander Krasniansky
 */
public class App {

    public static void main(String[] args) throws ConnectionException {

        // {1}
        AstyanaxContext<Keyspace> keyspaceCtx = new AstyanaxContext.Builder()
                .forCluster("kabzon")
                .forKeyspace("demo")
                .withAstyanaxConfiguration(
                        new AstyanaxConfigurationImpl()
                                .setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE)
                                .setConnectionPoolType(ConnectionPoolType.TOKEN_AWARE)
                ).withConnectionPoolConfiguration(
                        new ConnectionPoolConfigurationImpl("__pool")
                                .setPort(9160)
                                .setMaxConnsPerHost(3)
                                .setSeeds("127.0.0.1:9160")
                ).withConnectionPoolMonitor(
                        new CountingConnectionPoolMonitor()
                ).buildKeyspace(getInstance());

        keyspaceCtx.start();
        Keyspace keyspace = keyspaceCtx.getClient();

        // {2}
        keyspace.describeRing()
                .stream()
                .map((tRange) -> format("[%s\t~>\t%s]", tRange.getStartToken(), tRange.getEndToken()))
                .collect(toList())
                .forEach(out::println);

        keyspaceCtx.shutdown();
    }
}
