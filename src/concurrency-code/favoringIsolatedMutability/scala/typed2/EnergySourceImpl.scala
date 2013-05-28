package com.agiledeveloper.pcj

import akka.actor.TypedActor
import akka.actor.Scheduler
import java.util.concurrent.TimeUnit

//START:MURMUR
class EnergySourceImpl extends TypedActor with EnergySource {  
  val MAXLEVEL = 100L
  var level = MAXLEVEL
  var usageCount = 0L
  case class Replenish()
  override def preStart() = 
    Scheduler.schedule(self, Replenish, 1, 1, TimeUnit.SECONDS)
  override def postStop() = Scheduler.shutdown
  override def receive = processMessage orElse super.receive

  def processMessage : Receive = {
    case Replenish => 
      println("Thread in replenish: " + Thread.currentThread.getName)
      if (level < MAXLEVEL) level += 1
  }
//END:MURMUR

//START:RESTOFTHECLASS
  def getUnitsAvailable() = level
  def getUsageCount() = usageCount
  def useEnergy(units : Long) = {
    if (units > 0 && level - units >= 0) {
      println("Thread in useEnergy: " + Thread.currentThread.getName)
      level -= units
      usageCount += 1
    }
  }
}
//END:RESTOFTHECLASS
