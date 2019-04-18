package config

import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.IMongodConfig
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder
import de.flapdoodle.embed.mongo.config.Net
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import org.koin.core.KoinComponent
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value

class MongoExecutable:KoinComponent {

	fun get():MongodExecutable {
		
		val starter = MongodStarter.getDefaultInstance()

		val bindIp:String = MongoProperties.server
		val port = MongoProperties.port
		val mongodConfig:IMongodConfig  = MongodConfigBuilder()
							.version(Version.Main.PRODUCTION)
							.net(Net(bindIp, port, Network.localhostIsIPv6()))
							.build()
		
		return starter.prepare(mongodConfig)
	}

}