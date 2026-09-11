/**
 * 附身系统——smarter 的模式（非 agent 的模式）。
 * <p>
 * 附身是某些 agent 外延的模式，不是 agent 概念本身的模式（未来可能有不需要附身的纯规则 agent）。
 * agent 是 smarter 的具体实现（模式），故附身也是 smarter 的模式——放在 smarter 层，与 agent/ 并列。
 * <p>
 * 这个包中的附身功能类似于旁观者模式。
 * 玩家不会真正控制实体，只是以实体的视角观察，但附带给额外的区块更新等功能，附身的玩家是车万小女仆的工具。
 */
package com.github.magif1712.smarter_touhou_maids.features.smarter.possession;