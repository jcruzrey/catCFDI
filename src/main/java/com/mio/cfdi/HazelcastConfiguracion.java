/**
 * 
 */
package com.mio.cfdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

/**
 * @author jcruzrey
 *
 */
//@Configuration
public class HazelcastConfiguracion {
	//@Bean
    public Config hazelCastConfig(){
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("catalogo")
                                .setTimeToLiveSeconds(200000));
    }
}
